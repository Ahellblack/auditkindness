package com.siti.broadcast.mapper;

import com.siti.broadcast.po.Donate;
import com.siti.broadcast.vo.DonateVo;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface DonateMapper extends Mapper<Donate> {

    /**
     * 查询所有实时播报列表
     * @param headline
     * @param startDate
     * @param endDate
     * @param isTop */
    @Select({"<script>", "SELECT id,headline,DATE_FORMAT(pubdate,'%Y-%m-%d %H:%i:%s') pubDate,main_body mainBody,publish_source publishSource," +
            "url,vacancy,is_top*1 isTop,DATE_FORMAT(update_time,'%Y-%m-%d %H:%i:%s') updateTime,IF(TIMESTAMPDIFF(HOUR,pubdate,CURRENT_TIMESTAMP()) &lt; 1," +
            "concat(TIMESTAMPDIFF(MINUTE, pubdate, CURRENT_TIMESTAMP()),'分钟前'),IF(DATE(pubdate)=CURRENT_DATE()," +
            "concat(TIMESTAMPDIFF(HOUR,pubdate,CURRENT_TIMESTAMP()),'小时前'),concat(DATEDIFF(CURRENT_TIMESTAMP(),pubdate),'天前'))) duration," +
            "IF(d.pubdate=mxd.maxDate,1,null) isNew FROM donate d,(SELECT MAX(pubdate) maxDate FROM donate) mxd where 1=1 " +
            "<if test = \"headline!=null and headline!=''\"> and headline like '%${headline}' </if>" +
            "<if test = \"startDate!=null and startDate!='' and endDate!=null and endDate!=''\">" +
            " and pubDate &gt;= #{startDate} and pubDate &lt;= #{endDate} </if>" +
            "<if test = \"isTop!=null \"> and is_top=#{isTop} </if>" +
            " ORDER BY is_top DESC,pubdate DESC", "</script>"})
    List<DonateVo> getDonateInfo(@Param("headline") String headline, @Param("startDate") String startDate,
                                 @Param("endDate") String endDate, @Param("isTop") Integer isTop);


    @Update({"UPDATE `donate` SET `headline`=#{obj.headline}, `pubdate`=#{obj.pubdate}, `main_body`=#{obj.mainBody}," +
            " `publish_source`=#{obj.publishSource}, `url`=#{obj.url}, `is_top`=#{obj.isTop} WHERE (`id`=#{obj.id})"})
    void updateInf(@Param("obj") Donate donate);

    @Delete({"delete from `donate` where id=#{id}"})
    void deleteById(@Param("id") Integer id);
}
