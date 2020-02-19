package com.siti.broadcast.ctrl;

import com.github.pagehelper.PageInfo;
import com.siti.aop.annotation.Log;
import com.siti.broadcast.biz.DockMissionBiz;
import com.siti.broadcast.biz.DonateBiz;
import com.siti.broadcast.po.Donate;
import com.siti.broadcast.vo.DockingMissionVo;
import com.siti.broadcast.vo.DonateVo;
import com.siti.common.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("dock")
public class DockMissionCtrl {

    private static Logger logger = LoggerFactory.getLogger(DockMissionCtrl.class);

    @Resource
    private DockMissionBiz dockMissionBiz;

    @GetMapping(value = "getListByTab")
    public ReturnResult getDonateInfo(@RequestParam(name = "status", required = false) Integer status,
                                      @RequestParam(name = "title", required = false) String title,
                                      @RequestParam(name = "startDate", required = false) String startDate,
                                      @RequestParam(name = "endDate", required = false) String endDate,
                                      String tab, Integer page, Integer pageSize, HttpServletResponse response) {
        try {
            PageInfo<DockingMissionVo> pageInfo = dockMissionBiz.getMissionList(status, title, startDate, endDate, tab, page, pageSize);
            response.setHeader("Access-Control-Allow-Origin", "*");
            return new ReturnResult(1, "查询成功", pageInfo);
        } catch (Exception e) {
            return new ReturnResult(-1, "查询失败");
        }
    }

}
