package com.siti.material.ctrl;

import com.siti.common.ReturnResult;
import com.siti.material.biz.MaterialCheckBiz;
import com.siti.material.biz.MaterialPublishBiz;

import com.siti.material.po.Prepare;
import com.siti.material.po.SuppliesPublishCall;
import com.siti.material.po.SuppliesPublishEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: springbootvue
 * @description: 录入数据审核
 * @author: Que Zhixing
 * @create: 2020-02-11 16:57
 **/

@RestController
@RequestMapping("prepare")
public class PrepareController {

    @Resource
    MaterialCheckBiz materialCheckBiz;

    @Resource
    MaterialPublishBiz materialPublishBiz;

    @GetMapping("check")
    public ReturnResult check(String hosptialName){
        try {
            Map<String,List<String>> map = materialCheckBiz.materialCheck(hosptialName);
            return new ReturnResult(1,"查询结束",map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }
/*
    @GetMapping("publish")
    public ReturnResult publish(){
        try {
            List<SuppliesPublishEntity> list = materialPublishBiz.publishAll();
            return new ReturnResult(1,"查询结束",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }*/

    /**
     * @param id  prepareId
     * @param auditType 审核类型 1通过 -1不通过
     * */
    @GetMapping("hospitalAudit")
    public ReturnResult publishOne(Integer id,Integer auditType){
        try {
            Prepare data = materialPublishBiz.publishOne(id,auditType);
            if(data==null){
                return new ReturnResult(0,"审核失败，检查参数",data);
            }else{
                return new ReturnResult(1,"审核完成",data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }



    @GetMapping("convertCall")
    public ReturnResult convertCall(){
        try {
            List<SuppliesPublishCall> list = materialPublishBiz.convertCall();
            return new ReturnResult(1,"查询结束",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }
}
