package com.siti.material.ctrl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siti.aop.annotation.Log;
import com.siti.common.ReturnResult;
import com.siti.material.biz.MaterialCheckBiz;
import com.siti.material.biz.MaterialPublishBiz;

import com.siti.material.po.Prepare;
import com.siti.material.po.SuppliesPublishCall;
import com.siti.material.po.SuppliesPublishEntity;
import com.siti.material.vo.PrepareVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("getMeterialCheck")
    public ReturnResult check(Integer page,Integer pageSize,String hosptialName,Integer isAudit,Integer isDelete){
        try {
            PageInfo<Prepare> material = materialCheckBiz.getMaterial(page, pageSize, hosptialName, isAudit, isDelete);
            return new ReturnResult(1,"查询成功",material);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }
    @Log(operationType="update:",operationName="去除错误组织")
    @GetMapping("excludeUnValid")
    public ReturnResult excludeUnValid(){
        try {

            Map<String, Object> stringObjectMap = materialCheckBiz.materialCheck();
            return new ReturnResult(1,"操作完成",stringObjectMap);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }

    /**
     * @param materialType
     * @param status
     * @param createTime
     * @param needName
     * @param isAudit
     * @param isDelete
     *
     *
     * */
    @GetMapping("getMaterial")
    public ReturnResult getMaterial(Integer page,Integer pageSize,
                                    Integer materialType,Integer status,String createTime,String needName,Integer isAudit,Integer isDelete){
        try {
            PageInfo<PrepareVo> material = materialPublishBiz.getMaterial(page, pageSize, materialType, status, createTime, needName,isAudit, isDelete);
            return new ReturnResult(1,"查询结束",material);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }

    /**
     * @param id  prepareId
     * @param auditType 审核类型 1通过 -1不通过
     * */
    @GetMapping("audit")
    @Log(operationType="update:",operationName="审核组织")
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

    /**
     * @param id  prepareId
     * */
    @GetMapping("delete")
    @Log(operationType="update:",operationName="更改组织is_delete = 1")
    public ReturnResult deleteOne(Integer id){
        try {
            Integer data = materialPublishBiz.deleteOne(id);
            if(data==0){
                return new ReturnResult(0,"删除失败，检查参数",data);
            }else{
                return new ReturnResult(1,"删除成功",data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnResult(-1,"异常错误");
        }
    }

    /**

     * */
    @GetMapping("update")
    @Log(operationType="update:",operationName="修改组织信息")
    public ReturnResult update(@RequestBody Prepare prepare){
        try {
            Integer data = materialPublishBiz.update(prepare);
            if(data==0){
                return new ReturnResult(0,"修改失败，检查参数",data);
            }else{
                return new ReturnResult(1,"修改成功",data);
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
