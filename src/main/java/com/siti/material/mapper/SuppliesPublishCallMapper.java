package com.siti.material.mapper;

import com.siti.material.po.SuppliesPublishCall;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SuppliesPublishCallMapper {

    @Insert("INSERT ignore INTO `supplies_publish_call` (`publish_id`, `link_people`, `en_people`, `link_tel`, `tel_x`, " +
            "`en_tel_x`) VALUES ( " +
            " #{obj.publishId}," +
            " #{obj.linkPeople}," +
            " #{obj.enPeople}," +
            " #{obj.linktel}," +
            " #{obj.texX}," +
            " #{obj.enTelX}) ;")
    int insert(@Param("obj") SuppliesPublishCall suppliesPublishCall);

    @Select("SELECT * FROM supplies_publish_call;")
    List<SuppliesPublishCall> getAll();

    @Update("UPDATE supplies_publish_call set en_people=#{obj.enPeople},en_tel_x=#{obj.enTelX} WHERE id=#{obj.id};")
    int updateEnParam(@Param("obj") SuppliesPublishCall suppliesPublishCall);
}
