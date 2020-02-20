package com.siti.material.biz;

import com.siti.material.po.HospitalEntity;
import com.siti.material.po.SuppliesPublishCall;
import com.siti.material.po.SuppliesPublishEntity;
import com.siti.material.mapper.HospitalMapper;
import com.siti.material.mapper.SuppliesPublishCallMapper;
import com.siti.material.mapper.SuppliesPublishMapper;

import com.siti.utils.AESUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class EncryptBiz {
    @Resource
    HospitalMapper hospitalMapper;

    @Resource
    SuppliesPublishMapper suppliesPublishMapper;

    @Resource
    SuppliesPublishCallMapper suppliesPublishCallMapper;


    public List<HospitalEntity> transHospital(){
        String hospitalName;
        String hospitalAddress;
        String gaodeLon;
        String gaodeLat;
        String enHospitalName;
        String enHospitalAddress;
        String enGaodeLon;
        String enGaodeLat;

        List<HospitalEntity> list = hospitalMapper.getAllPartParam();

        for (HospitalEntity entity: list){
            try {
                hospitalName = entity.getHospitalName();
                hospitalAddress = entity.getHospitalAddress();
                gaodeLon = entity.getGaodeLon();
                gaodeLat = entity.getGaodeLat();
                enHospitalName = hospitalName != null && !hospitalName.equals("") ?
                        AESUtil.Encrypt(hospitalName).replaceAll("[\\s*\t\n\r]", "") : null;
                enHospitalAddress = hospitalAddress != null && !hospitalAddress.equals("") ?
                        AESUtil.Encrypt(hospitalAddress).replaceAll("[\\s*\t\n\r]", "") : null;
                enGaodeLon = gaodeLon != null && !gaodeLon.equals("") ? AESUtil.Encrypt(gaodeLon).replaceAll("[\\s*\t\n\r]", "") : null;
                enGaodeLat = gaodeLat != null && !gaodeLat.equals("") ? AESUtil.Encrypt(gaodeLat).replaceAll("[\\s*\t\n\r]", "") : null;
                System.out.println("加密前:"+hospitalAddress + ", 加密后："+enHospitalAddress + "，解密后："+AESUtil.Decrypt(enHospitalAddress) + "\n");

                entity.setEnHospital(enHospitalName);  // 字符过长会被换行分割
                entity.setEnHospitalAddress(enHospitalAddress);
                entity.setEnGaodeLon(enGaodeLon);
                entity.setEnGaodeLat(enGaodeLat);
                hospitalMapper.updateHospitalEncryptParam(entity);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }

        return list;
    }


    public List<SuppliesPublishEntity> transSupplies(){
        String linkPeople;
        String linkTel;
        String enLinkPeople;
        String enLinkTel;

        List<SuppliesPublishEntity> list = suppliesPublishMapper.getAllPartParam();

        for (SuppliesPublishEntity entity: list){
            try {
                linkPeople = entity.getLinkPeople();
                linkTel = entity.getLinkTel();
                enLinkPeople = linkPeople != null && !linkPeople.equals("") ? AESUtil.Encrypt(linkPeople).replaceAll("[\\s*\t\n\r]", "") : null;
                enLinkTel = linkTel != null && !linkTel.equals("") ? AESUtil.Encrypt(linkTel).replaceAll("[\\s*\t\n\r]", "") : null;

                entity.setEnLinkPeople(enLinkPeople);
                entity.setEnLinkTel(enLinkTel);

                System.out.println(entity.toString());
                suppliesPublishMapper.updateSuppliesEncryptParam(entity);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }

        return list;
    }


    public List<SuppliesPublishCall> transCalls(){
        String linkPeople;
        String linkTel;
        String enLinkPeople;
        String enLinkTel;

        List<SuppliesPublishCall> list = suppliesPublishCallMapper.getAll();

        for (SuppliesPublishCall entity: list){
            try {
                linkPeople = entity.getLinkPeople();
                enLinkPeople = linkPeople != null && !linkPeople.equals("") ? AESUtil.Encrypt(linkPeople).replaceAll("[\\s*\t\n\r]", "") : null;

                entity.setEnPeople(enLinkPeople);

                System.out.println(entity.toString());
                suppliesPublishCallMapper.updateEnParam(entity);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        return list;
    }
}
