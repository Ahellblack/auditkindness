package com.siti.hospital.ctrl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siti.common.ReturnResult;
import com.siti.hospital.biz.HospitalBiz;
import com.siti.hospital.po.Hospital;
import com.siti.hospital.vo.HospitalVo;
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

    /**
     *  @param page
     *  @param pageSize
     *  @param content
     *  @param startTime 起始时间
     *  @param endTime 末尾时间
     *  @param orgType 组织类型
     * */
    @GetMapping(value = "getHospital")
    public ReturnResult selectHospital(Integer page,Integer pageSize,String content, String startTime,String endTime, Integer orgType) {
        try {
            PageInfo<HospitalVo> pageInfo = hospitalBiz.selectHospital(page, pageSize, content, startTime, endTime, orgType);
            return new ReturnResult(1,"请求成功",pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ReturnResult(-1,"请求失败");
    }

}
