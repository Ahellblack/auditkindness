package com.siti.material.ctrl;

import com.alibaba.fastjson.JSONObject;
import com.siti.common.ReturnResult;
import com.siti.material.biz.EncryptBiz;

import com.siti.material.po.HospitalEntity;
import com.siti.material.po.SuppliesPublishCall;
import com.siti.material.po.SuppliesPublishEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("encrypt")
public class EncryptController {

    @Resource
    EncryptBiz encryptBiz;

    @GetMapping(value = "encryptAll")
    public ReturnResult encryptAll() {
        try {
            List<HospitalEntity> list1 = encryptBiz.transHospital();
            List<SuppliesPublishEntity> list2 = encryptBiz.transSupplies();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("hospitalList",list1);
            jsonObject.put("suppliesList",list2);
            return new ReturnResult(1,"查询结束",jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }


    @GetMapping(value = "encryptHospital")
    public ReturnResult encryptHospital() {
        try {
            List<HospitalEntity> list1 = encryptBiz.transHospital();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("hospitalList",list1);
            return new ReturnResult(1,"查询结束",jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }

    @GetMapping(value = "encryptCalls")
    public ReturnResult encryptCalls() {
        try {
            List<SuppliesPublishCall> list1 = encryptBiz.transCalls();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("hospitalList",list1);
            return new ReturnResult(1,"查询结束",jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }

    @GetMapping(value = "encryptSupplies")
    public ReturnResult encryptSupplies() {
        try {
            List<SuppliesPublishEntity> list2 = encryptBiz.transSupplies();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("suppliesList",list2);
            return new ReturnResult(1,"查询结束",jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }
}
