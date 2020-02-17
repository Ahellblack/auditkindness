package com.siti.material.biz;

import com.siti.material.po.*;
import com.siti.material.mapper.*;
import com.siti.utils.AESUtil;
import com.siti.utils.LngLonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springbootvue
 * @description: material数据发布
 * @author: Que Zhixing
 * @create: 2020-02-11 19:39
 **/

@Service
public class MaterialPublishBiz {
    @Resource
    PrepareMapper prepareMapper;

    @Resource
    HospitalMapper hospitalMapper;

    @Resource
    SuppliesPublishMapper suppliesPublishMapper;

    @Resource
    SuppliesPublishDetailMapper suppliesPublishDetailMapper;

    @Resource
    SuppliesPublishCallMapper suppliesPublishCallMapper;

    @Resource
    PrepareDetailMapper prepareDetailMapper;

    public List<SuppliesPublishEntity> publishAll(){
        List<Prepare> list = prepareMapper.getAllNeedShow();
        List<SuppliesPublishEntity> publishList = new ArrayList<>();

        for (Prepare entity : list){
            SuppliesPublishEntity publishEntity = publishOne(entity.getId(),1);
            publishList.add(publishEntity);
        }

        return publishList;
    }

    @Transactional
    public SuppliesPublishEntity publishOne(int id,Integer auditType){
        Prepare Prepare = prepareMapper.getById(id);

        try {
            if (Prepare != null){
                if(auditType==-1){
                    Prepare.setIsAudit(-1);
                    prepareMapper.updateStatus(Prepare);
                }

                HospitalEntity hospital = materialToHospital(Prepare);
                SuppliesPublishEntity suppliesPublish = materialToSuppliesPublish(Prepare);

                // 不存在于hostipal，则新增
                if (hospitalMapper.getCountByName(Prepare.getName()) < 1){
                    hospitalMapper.insert(hospital);
                }
                else {
                    hospitalMapper.updateByName(hospital,Prepare.getName());
                }

                //  publish表可直接新增
                suppliesPublishMapper.insert(suppliesPublish);
                List<SuppliesPublishDetail> detailList =  publishOneDetail(id);  // 更新detail
                List<SuppliesPublishCall> callList = publishOneCall(id); // 更新call

                prepareMapper.updateHasShowStatus(id);  // 发布完成后更新hasShow状态
                System.out.println("更新" + hospital.toString() + "," + suppliesPublish.toString() + "," + detailList);

            }
            else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 更新一条记录的物品详情
    public List<SuppliesPublishDetail> publishOneDetail(int materialId){
        String hospitalName = prepareMapper.getById(materialId).getName();
        Integer publishId = suppliesPublishMapper.getLastPublishIdByName(hospitalName);
        List<SuppliesPublishDetail> detailList = new ArrayList<>();

        List<PrepareDetail> list = prepareDetailMapper.getAllByMaterialId(materialId);
        for (PrepareDetail entity : list){
            SuppliesPublishDetail publishDetail = new SuppliesPublishDetail();
            publishDetail.setPublishId(publishId);
            publishDetail.setNeedsName(entity.getNeedsName());
            publishDetail.setDescr(entity.getDescr());

            // 不存在重复的则插入，否则更新
            if (null == suppliesPublishDetailMapper.getByParams(publishDetail)){
                suppliesPublishDetailMapper.insert(publishDetail);
                System.out.print("插入"+publishDetail.toString());
            }
            else {
                suppliesPublishDetailMapper.updateDescr(publishDetail);
                System.out.print("更新"+publishDetail.toString());
            }
            System.out.println();
            detailList.add(publishDetail);
        }

        return detailList;
    }

    // 更新一条记录的电话信息
    public List<SuppliesPublishCall> convertCall() throws Exception {
        List<SuppliesPublishCall> callList = new ArrayList<>();

        List<SuppliesPublishEntity> list = suppliesPublishMapper.getAll();
        for (SuppliesPublishEntity entity : list){
            String linkPeopleStr = entity.getLinkPeople() == null ? "" : entity.getLinkPeople();
            String linkTelStr = entity.getLinkTel() == null ? "" : entity.getLinkTel();

            String[] tel = linkTelStr.split(",",5);
            String[] peo = linkPeopleStr.split(",",5);
            if (tel[0].equals("")){
                continue;
            }
            for (int i = 0; i < tel.length; i ++){
                SuppliesPublishCall publishCall = new SuppliesPublishCall();

                String linkPeople = i >= peo.length ? "联系人" : (peo[i].equals("") ? "联系人": peo[i]);  // 联系人可能比号码少
                String linkTel = tel[i].replaceAll("[^\\d]+","");

                if (linkTel.startsWith("1") && linkTel.length()==11){
                    publishCall.setLinktel("86" + linkTel);  // 手机号前加86
                }
                else if (linkTel.startsWith("0") && 10 <= linkTel.length() && linkTel.length() <= 12){
                    publishCall.setLinktel("86" + linkTel.subSequence(1,linkTel.length()-1));  // 固话前去除0再加86
                }
                else if (linkTel.startsWith("400")){
                    publishCall.setLinktel("86" + linkTel);  // 400类碘化铅加86
                }
                else {
                    publishCall.setLinktel(linkTel);  // 其它类型号码要么错误要么未国际电话，保持不变
                }

                publishCall.setPublishId(entity.getId());
                publishCall.setLinkPeople(linkPeople);
                publishCall.setEnPeople(AESUtil.Encrypt(linkPeople).replaceAll("[\\s*\t\n\r]", ""));

                suppliesPublishCallMapper.insert(publishCall);
                System.out.println(publishCall.toString());
                callList.add(publishCall);
            }
        }

        return callList;
    }


    // 更新一条记录的电话信息，从material
    public List<SuppliesPublishCall> publishOneCall(int materialId) throws Exception {
        Prepare Prepare = prepareMapper.getById(materialId);
        Integer publishId = suppliesPublishMapper.getLastPublishIdByName(Prepare.getName());
        List<SuppliesPublishCall> callList = new ArrayList<>();

        List<String> peopleList = new ArrayList<>();
        List<String> telList = new ArrayList<>();
        String[] peoTel = Prepare.getLinkPeople().split(",",5);
        for (String s : peoTel) {
            String[] peoTelArray = s.split(":");
            peopleList.add(peoTelArray[0]);
            telList.add(peoTelArray[1]);
        }
        if(telList.get(0).equals("") || telList.get(0).equals(" ")){
            return null;  // 一个联系电话都没有则返回
        }

        for (int i = 0; i < telList.size(); i ++){
            SuppliesPublishCall publishCall = new SuppliesPublishCall();
            String linkPeople = peopleList.size() - 1 < i || peopleList.get(i).equals("") ?"联系人":peopleList.get(i);  // 联系人比联系电话少时，默认为  联系人
            String linkTel = telList.get(i).replaceAll("[^\\d]+","");

            if (linkTel.startsWith("1") && linkTel.length()==11){
                publishCall.setLinktel("86" + linkTel);  // 手机号前加86
            }
            else if (linkTel.startsWith("0") && 10 <= linkTel.length() && linkTel.length() <= 12){
                publishCall.setLinktel("86" + linkTel.subSequence(1,linkTel.length()-1));  // 固话前去除0再加86
            }
            else if (linkTel.startsWith("400")){
                publishCall.setLinktel("86" + linkTel);  // 400类号码加86
            }
            else {
                publishCall.setLinktel(linkTel);  // 其它类型号码要么错误要么为国际电话，保持不变
            }

            publishCall.setPublishId(publishId);
            publishCall.setLinkPeople(linkPeople);
            publishCall.setEnPeople( AESUtil.Encrypt(linkPeople).replaceAll("[\\s*\t\n\r]", ""));

            suppliesPublishCallMapper.insert(publishCall);
            callList.add(publishCall);
        }

        return callList;
    }

    // material转换为hospital
    public HospitalEntity materialToHospital(Prepare Prepare) throws Exception {
        HospitalEntity hospital = new HospitalEntity();

        if (!Prepare.getLongitude().isEmpty() && !Prepare.getLatitude().isEmpty()){
            double lon = Double.parseDouble(Prepare.getLongitude());
            double lat = Double.parseDouble(Prepare.getLatitude());

            double[] gps = LngLonUtil.bd09_To_Gcj02(lon,lat);

            String gaodeLon = String.valueOf(gps[0]);
            String gaodeLat = String.valueOf(gps[1]);
            String enGaodeLon = AESUtil.Encrypt(gaodeLon).replaceAll("[\\s*\t\n\r]", "");
            String enGaodeLat = AESUtil.Encrypt(gaodeLat).replaceAll("[\\s*\t\n\r]", "");

            hospital.setLongitude(Prepare.getLongitude());
            hospital.setLatidute(Prepare.getLatitude());
            hospital.setGaodeLon(gaodeLon);
            hospital.setGaodeLat(gaodeLat);
            hospital.setEnGaodeLon(enGaodeLon);
            hospital.setEnGaodeLat(enGaodeLat);
        }

        // 如此转换的原因是数据库的material和hospital的字段值设定
        if (Prepare.getMaterialType() == 1){
            hospital.setIsLack(1);   // 需求方才设置
            if (Prepare.getType() == 4){
                hospital.setType(1);  // 定点医院
            }
            else if (Prepare.getType() == 5){
                hospital.setType(2);  // 发热门诊
            }
            else {
                hospital.setType(0);  // 普通医疗结构
            }
        }
        else if (Prepare.getMaterialType() == 2){
            hospital.setType(3);  // 供给方
        }
        else if (Prepare.getMaterialType() == 3){
            hospital.setType(4);  // 社会组织
        }
        else {
            hospital.setType(null);  // 错误类型
        }


        String enHospital = !Prepare.getName().isEmpty() ? AESUtil.Encrypt(Prepare.getName()).
                replaceAll("[\\s*\t\n\r]", "") : null;
        String enAddress = !Prepare.getAddress().isEmpty() ? AESUtil.Encrypt(Prepare.getAddress()).
                replaceAll("[\\s*\t\n\r]", "") : null;

        hospital.setProvince(Prepare.getProvince());
        hospital.setCity(Prepare.getCity());
        hospital.setHospitalName(Prepare.getName());
        hospital.setHospitalAddress(Prepare.getAddress());
        hospital.setOrgType(Prepare.getMaterialType());
        hospital.setEnHospital(enHospital);
        hospital.setEnHospitalAddress(enAddress);

        return hospital;
    }


    // material转换为publish
    public SuppliesPublishEntity materialToSuppliesPublish(Prepare Prepare) throws Exception {
        SuppliesPublishEntity publishEntity = new SuppliesPublishEntity();

        List<String> peopleList = new ArrayList<>();
        List<String> telList = new ArrayList<>();
        String[] peoTel = Prepare.getLinkPeople().split(",",5);
        for (String s : peoTel) {
            String[] peoTelArray = s.split(":");
            peopleList.add(peoTelArray[0]);
            telList.add(peoTelArray[1]);
        }

        String linkPeople = String.join(",", peopleList);
        String linkTel = String.join(",", telList);
        String enLinkPeople =  !linkPeople.isEmpty() ? AESUtil.Encrypt(linkPeople).
                replaceAll("[\\s*\t\n\r]", "") : null;
        String enLinkTel = !linkTel.isEmpty() ? AESUtil.Encrypt(linkTel).
                replaceAll("[\\s*\t\n\r]", "") : null;

        publishEntity.setHopistalName(Prepare.getName());
        publishEntity.setLinkAddress(Prepare.getAddress());
        publishEntity.setLinkPeople(linkPeople);
        publishEntity.setLinkTel(linkTel);
        publishEntity.setEnLinkPeople(enLinkPeople);
        publishEntity.setEnLinkTel(enLinkTel);
        publishEntity.setDescr(Prepare.getNeedsDescr());
        publishEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));

        return publishEntity;
    }
}
