package com.siti.broadcast.ctrl;

import com.github.pagehelper.PageInfo;
import com.siti.aop.annotation.Log;
import com.siti.broadcast.biz.DonateBiz;
import com.siti.broadcast.biz.FundInfoBiz;
import com.siti.broadcast.po.Donate;
import com.siti.broadcast.po.FundInfo;
import com.siti.broadcast.vo.DonateVo;
import com.siti.common.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("fundInfo")
public class FundInfoCtrl {

    private static Logger logger = LoggerFactory.getLogger(FundInfoCtrl.class);

    @Resource
    private FundInfoBiz fundInfoBiz;

    /**
     * 添加*/
    @Log(operationType="insert:",operationName="添加资助信息")
    @PostMapping("insert")
    public ReturnResult insertInf(FundInfo info) {
        try {
            fundInfoBiz.insert(info);
            return new ReturnResult(1, "添加成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ReturnResult(-1, "添加失败");
        }
    }

    /**
     * 修改*/
    @Log(operationType="update:",operationName="修改资助信息")
    @PostMapping("update")
    public ReturnResult updateInf(FundInfo info) {
        try {
            fundInfoBiz.update(info);
            return new ReturnResult(1, "修改成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ReturnResult(-1, "修改失败");
        }
    }

    /**
     * 删除*/
    @Log(operationType="delete:",operationName="删除资助信息")
    @PostMapping("delete")
    public ReturnResult deleteInf(Integer id) {
        try {
            fundInfoBiz.delete(id);
            return new ReturnResult(1, "删除成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ReturnResult(-1, "删除失败");
        }
    }
}
