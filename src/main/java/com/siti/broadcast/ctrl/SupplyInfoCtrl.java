package com.siti.broadcast.ctrl;

import com.siti.aop.annotation.Log;
import com.siti.broadcast.biz.PurchaseDemandBiz;
import com.siti.broadcast.biz.SupplyInfoBiz;
import com.siti.broadcast.po.PurchaseDemand;
import com.siti.broadcast.po.SupplyInfo;
import com.siti.common.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("supplyInfo")
public class SupplyInfoCtrl {

    private static Logger logger = LoggerFactory.getLogger(SupplyInfoCtrl.class);

    @Resource
    private SupplyInfoBiz supplyInfoBiz;

    /**
     * 添加*/
    @Log(operationType="insert:",operationName="添加供应信息")
    @PostMapping("insert")
    public ReturnResult insertInf(SupplyInfo info) {
        try {
            supplyInfoBiz.insert(info);
            return new ReturnResult(1, "添加成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ReturnResult(-1, "添加失败");
        }
    }

    /**
     * 修改*/
    @Log(operationType="update:",operationName="修改供应信息")
    @PostMapping("update")
    public ReturnResult updateInf(SupplyInfo info) {
        try {
            supplyInfoBiz.update(info);
            return new ReturnResult(1, "修改成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ReturnResult(-1, "修改失败");
        }
    }

    /**
     * 删除*/
    @Log(operationType="delete:",operationName="删除供应信息")
    @PostMapping("delete")
    public ReturnResult deleteInf(Integer id) {
        try {
            supplyInfoBiz.delete(id);
            return new ReturnResult(1, "删除成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ReturnResult(-1, "删除失败");
        }
    }
}
