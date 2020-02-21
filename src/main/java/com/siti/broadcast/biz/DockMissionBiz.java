package com.siti.broadcast.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siti.broadcast.mapper.DockMissionMapper;
import com.siti.broadcast.vo.DockingMissionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DockMissionBiz {

    @Resource
    DockMissionMapper dockMissionMapper;

    /**
     * 獲取任務榜單
     *
     * @param status
     * @param tabName
     * @param page
     * @param pageSize
     * @param endDate
     * @param startDate
     * @param title
     */
    public PageInfo<DockingMissionVo> getMissionList(Integer status, String title, String startDate, String endDate, String tabName, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        String tableName = null;
        if (tabName != null && !"".equals(tabName)) {
            switch (tabName) {
                case "fund" :
                    tableName = "fund_info";
                    break;
                case "purchase" :
                    tableName = "purchase_demand";
                    break;
                case "supply" :
                    tableName = "supply_info";
                    break;
                default:
                    break;
            }
        }
        List<DockingMissionVo> info = new ArrayList<>();
        if (tableName != null ) {
            info = dockMissionMapper.getMissionList(status, title, startDate, endDate, tableName);
        }
        PageInfo<DockingMissionVo> pageInfo = new PageInfo<>(info);
        return pageInfo;
    }

    public List<String> getTitleListByTab(String title,String tab) {

        String tableName = null;
        if (tab != null && !"".equals(tab)) {
            switch (tab) {
                case "fund" :
                    tableName = "fund_info";
                    break;
                case "purchase" :
                    tableName = "purchase_demand";
                    break;
                case "supply" :
                    tableName = "supply_info";
                    break;
                default:
                    break;
            }
        }
        List<String> list = new ArrayList<>();
        if (tableName != null ) {
            list = dockMissionMapper.getTitle(title,tableName);
        }

        return list;
    }
}
