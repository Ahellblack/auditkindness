package com.siti.broadcast.mapper;

import com.siti.broadcast.vo.DockingMissionVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DockMissionMapper {

    @Select({"<script>", "SELECT id,title,body,status*1 status,attachment_link links,DATE_FORMAT(update_time,'%Y-%m-%d %H:%i:%s') updateTime " +
            " FROM ${tableName} WHERE 1=1" +
            "<if test=\"status!=null\"> and status=#{status} </if>" +
            "<if test=\"title!=null\"> and title like '%${title}' </if>" +
            "<if test = \"startDate!=null and startDate!='' and endDate!=null and endDate!=''\">" +
            " and update_time &gt;= #{startDate} and update_time &lt;= #{endDate} </if>" +
            " ORDER BY update_time DESC", "</script>"})
    List<DockingMissionVo> getMissionList(@Param("status") Integer status, @Param("title") String title,
                                          @Param("startDate") String startDate, @Param("endDate") String endDate,
                                          @Param("tableName") String tableName);




    @Select({"<script>", "SELECT title  " +
            " FROM ${tableName} WHERE 1=1" +
            "<if test=\"title!=null\"> and title like '%${title}%' </if>" +
            " ORDER BY update_time DESC", "</script>"})
    List<String> getTitle(@Param("title") String title,@Param("tableName")String tableName);
}
