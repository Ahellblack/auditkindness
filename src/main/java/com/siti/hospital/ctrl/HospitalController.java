package com.siti.hospital.ctrl;

import com.siti.common.ReturnResult;
import com.siti.hospital.biz.HospitalBiz;
import com.siti.hospital.po.Hospital;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springbootvue
 * @description: 录入数据审核
 * @author: Que Zhixing
 * @create: 2020-02-11 16:57
 **/

@RestController
@RequestMapping("hospital")
public class HospitalController {


    @Resource
    private HospitalBiz hospitalBiz;

    @GetMapping(value = "getHospital")
    public ReturnResult selectHospital(String content, Integer hour, Integer orgType) {
        try {
            List<Hospital> hospitals = hospitalBiz.selectHospital(content, hour, orgType);
            return new ReturnResult(1,"请求成功",hospitals);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ReturnResult(-1,"请求失败");
    }

}
