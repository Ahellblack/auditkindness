package com.siti.material.mapper;

import com.siti.material.po.SuppliesPublishEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SuppliesPublishMapper {
    @Select("SELECT * FROM supplies_publish;")
    List<SuppliesPublishEntity> getAll();

    @Select("SELECT id,link_people,link_tel FROM supplies_publish;")
    List<SuppliesPublishEntity> getAllPartParam();

    @Select("select id from supplies_publish where hospital_name=#{hospitalName} order by id desc limit 1;")
    int getLastPublishIdByName(@Param("hospitalName") String hospitalName);

    @Select("select * from supplies_publish where hospital_name=#{hospitalName} order by id desc limit 1;")
    SuppliesPublishEntity getLastPublishByName(@Param("hospitalName") String hospitalName);

    @Update("UPDATE supplies_publish set " +
            "en_people=#{obj.enLinkPeople}," +
            "en_tel=#{obj.enLinkTel} " +
            "where id=${obj.id};")
    int updateSuppliesEncryptParam(@Param("obj") SuppliesPublishEntity suppliesPublishEntity);


    @Insert("INSERT INTO `supplies_publish` (`hospital_name`, `link_address`, `link_people`, `en_people`," +
            " `link_tel`, `en_tel`, `create_time`, `source`, `source_link`, `descr`) VALUES (" +
            "#{obj.hopistalName}," +
            "#{obj.linkAddress}," +
            "#{obj.linkPeople}," +
            "#{obj.enLinkPeople}," +
            "#{obj.linkTel}," +
            "#{obj.enLinkTel}," +
            "#{obj.createTime}," +
            "#{obj.source}," +
            "#{obj.sourceLink}," +
            "#{obj.descr})")
    int insert(@Param("obj") SuppliesPublishEntity suppliesPublishEntity);
}