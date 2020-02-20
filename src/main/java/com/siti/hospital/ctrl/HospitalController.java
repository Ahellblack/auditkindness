package com.siti.hospital.ctrl;

import com.siti.common.ReturnResult;
import com.siti.hospital.biz.HospitalBiz;
import com.siti.hospital.po.Hospital;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("hospital")
public class HospitalController {


    @Resource
    private HospitalBiz hospitalBiz;

/*
    @RequestLimit(maxCount = 10)
*/
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
