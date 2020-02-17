package com.siti.material.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siti.material.mapper.PrepareMapper;
import com.siti.material.po.Prepare;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springbootvue
 * @description:
 * @author: Que Zhixing
 * @create: 2020-02-11 17:06
 **/

@Service
public class MaterialCheckBiz {

    @Resource
    PrepareMapper prepareMapper;

    public Map<String,Object> materialCheck(Integer page,Integer pageSize,String hospitalName){
        Map<String,Object> map = new HashMap<>();
        List<Prepare> validList = new ArrayList<>();
        List<Prepare> notValidList = new ArrayList<>();
        PageHelper.startPage(page, pageSize);

        List<Prepare> list = prepareMapper.getAllUnaudit(hospitalName);
        for (Prepare entity : list){
            String checkDescr = "";
            boolean entityIsValid = true;
            if (!checkProvince(entity.getProvince())){
                checkDescr = checkDescr.concat("省份不规范,");
                entityIsValid = false;
            }
            if (!checkCity(entity.getCity())){
                checkDescr = checkDescr.concat("城市不规范,");
                entityIsValid = false;
            }
            if (!checkLon(entity.getLongitude())){
                checkDescr = checkDescr.concat("经度不规范,");
                entityIsValid = false;
            }
            if (!checkLat(entity.getLatitude())){
                checkDescr = checkDescr.concat("纬度不规范,");
                entityIsValid = false;
            }
            if (!checkLinkPeople(entity.getLinkPeople())){
                checkDescr = checkDescr.concat("电话号码非常规,");
                entityIsValid = false;
            }

            // 更新审核状态,
            if (entityIsValid){
                entity.setIsDelete(0);
                entity.setIsAudit(0);
                prepareMapper.updateStatus(entity);
                validList.add(entity);
            }
            else {
                entity.setIsDelete(0);
                entity.setIsAudit(-1);
                prepareMapper.updateStatus(entity);
                notValidList.add(entity);
            }
            System.out.println(entity.toString());
        }
        PageInfo<Prepare> validpageInfo = new PageInfo<>(validList);
        PageInfo<Prepare> notValidpageInfo = new PageInfo<>(notValidList);
        map.put("合格组织", validpageInfo);
        map.put("不合规组织", notValidpageInfo);
        return map;
    }

    // 检查省份
    public boolean checkProvince(String province){
        if (null == province || province.isEmpty()){
            return false;
        }
        else {
            return province.endsWith("省") || province.endsWith("市") || province.endsWith("区");
        }
    }

    // 检查城市
    public boolean checkCity(String city){
        if (null == city || city.isEmpty()){
            return false;
        }
        else {
            return city.endsWith("市") || city.endsWith("区") || city.endsWith("州") || city.endsWith("行政区划");
        }
    }

    // 检查经度
    public boolean checkLon(String lon){
        if (null == lon || lon.isEmpty()){
            return false;
        }
        else {
            return Float.parseFloat(lon) > 90;
        }
    }

    // 检查纬度
    public boolean checkLat(String lat){
        if (null == lat || lat.isEmpty()){
            return false;
        }
        else {
            return Float.parseFloat(lat) < 90;
        }
    }

    // 检查联系人-号码
    public boolean checkLinkPeople(String linkPeople){
        if (null == linkPeople || linkPeople.isEmpty()){
            return false;
        }
        else {
            String[] peoTel = linkPeople.split(",",5);
            for (String s : peoTel) {
                String[] peopleArray = s.split(":");
                boolean telIsValid = checkTel(peopleArray[1]);
                if (!telIsValid) {  // 但凡有一个号码或姓名有错则返回false
                    return false;
                }
            }
            return true;
        }
    }

    // 检查姓名
    private boolean checkTel(String tel){
        if (null == tel || tel.isEmpty()){
            return false;
        }
        else {
            String telRegex = "[1][356789]\\d{9}";
            if (tel.startsWith("0")){  // 固话满足 3+7 至4+8长度
                return 10 <= tel.length() && tel.length() <= 12;
            }
            else if (tel.startsWith("1")){  // 手机号码满足正则表达式
                return tel.matches(telRegex);
            }
            else {
                return false;
            }
        }
    }

    // 检查号码
    private boolean checkPeople(String people){
        return true;
    }
}
