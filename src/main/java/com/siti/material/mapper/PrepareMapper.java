package com.siti.material.mapper;


import com.siti.material.po.Prepare;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PrepareMapper extends Mapper<Prepare> {

    @Select("<script>" +
            "select * from prepare where is_audit = 0 and is_delete = 0 " +
            "<if test = \"hospitalName!=null and hospitalName!=''\"> where name like '%${hospitalName}' </if>" +
            "</script>")
    List<Prepare> getAllUnaudit(@Param("hospitalName") String hospitalName);

    @Select("update prepare set is_audit = #{entity.isAudit}, is_delete = #{entity.isDelete} where id = #{entity.id}")
    Integer updateStatus(@Param("entity")Prepare prepare );


    @Select("SELECT * FROM prepare WHERE id = #{Id};")
    Prepare getById(@Param("Id") Integer id);

    @Select("SELECT * FROM prepare WHERE has_show=0 and is_valid=1;")
    List<Prepare> getAllNeedShow();

    @Select("SELECT * FROM prepare WHERE id=#{id} and is_valid=1 ;")
    Prepare getOneNeedShow(int id);


    @Select("SELECT * FROM prepare WHERE has_show=0;")
    List<Prepare> getAllNotShow();

    @Update("UPDATE `prepare` SET `has_show`='1' WHERE (`id`=#{id});")
    int updateHasShowStatus(int id);

    @Update("UPDATE prepare set is_valid=#{obj.isValid}, check_descr=#{obj.checkDescr},has_show=#{obj.hasShow} " +
            "where id = #{obj.id};")
    int updateCheckStatus(@Param("obj") Prepare Prepare);
}
