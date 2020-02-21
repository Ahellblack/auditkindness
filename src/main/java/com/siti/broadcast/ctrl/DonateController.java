package com.siti.broadcast.ctrl;

import com.github.pagehelper.PageInfo;
import com.siti.aop.annotation.Log;
import com.siti.broadcast.biz.DonateBiz;
import com.siti.broadcast.po.Donate;
import com.siti.broadcast.vo.DonateVo;
import com.siti.common.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("donate")
public class DonateController {

    private static Logger logger = LoggerFactory.getLogger(DonateController.class);

    @Resource
    private DonateBiz donateBiz;

    @GetMapping(value = "getInfo")
    public ReturnResult getDonateInfo(@RequestParam(name = "headline", required = false) String headline,
                                      @RequestParam(name = "startDate", required = false) String startDate,
                                      @RequestParam(name = "endDate", required = false) String endDate,
                                      @RequestParam(name = "isTop", required = false) Integer isTop,
                                      Integer page, Integer pageSize) {
        try {
            PageInfo<DonateVo> info = donateBiz.getDonateInfo(headline,startDate,endDate,isTop ,page, pageSize);
            return new ReturnResult(1,"查询结束",info);
        } catch (Exception e) {
            return  new ReturnResult(-1, "查询失败");
        }
    }

    /**
     * 添加*/
    @Log(operationType="insert:",operationName="添加实时播报信息")
    @PostMapping("insert")
    public ReturnResult insertInf(Donate donate) {
        try {
            donateBiz.insert(donate);
            return new ReturnResult(1, "添加成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ReturnResult(-1, "添加失败");
        }
    }

    /**
     * 修改*/
    @Log(operationType="update:",operationName="修改实时播报信息")
    @PostMapping("update")
    public ReturnResult updateInf(Donate donate) {
        try {
            donateBiz.update(donate);
            return new ReturnResult(1, "修改成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ReturnResult(-1, "修改失败");
        }
    }

    /**
     * 删除*/
    @Log(operationType="delete:",operationName="删除实时播报信息")
    @PostMapping("delete")
    public ReturnResult deleteInf(Integer id) {
        try {
            donateBiz.delete(id);
            return new ReturnResult(1, "删除成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ReturnResult(-1, "删除失败");
        }
    }

    /*-----------------------------------------------------------------------*/

    /**
     * 标题下拉框*/
    @GetMapping("getHeadline")
    public ReturnResult getHeadline(String headline) {
        try {
            List<String> list = donateBiz.getHeadline(headline);
            return new ReturnResult(1, "查询成功",list);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ReturnResult(-1, "查询失败");
        }
    }


}
