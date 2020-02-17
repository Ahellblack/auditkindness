package com.siti.material.mapper;


import com.siti.material.po.Prepare;
import com.siti.material.po.PrepareDetail;
import com.siti.material.vo.PrepareVo;
import org.apache.ibatis.annotations.*;
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


    /**
     * 根据条件筛选信息
     *
     * @return
     */
    @Select("<script>" +
            "      SELECT * FROM `prepare` p left join `prepare_detail` pd on pd.material_id = p.id where 1=1 " +
            "       <if test=\" materialType!=null and materialType!=''\">and  p.material_type = #{materialType}</if>" +
            "       <if test=\" status!=null and status!=''\"> and p.status = #{status} </if>" +
            "       <if test=\" createTime!=null and createTime!=''\"> and p.create_time like '%${createTime}%'</if>" +
            "       <if test=\" needName!=null and needName!=''\"> and needs_name like '%${needName}%' </if>" +
            "</script>")
     /* @Results(id = "progItem", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "prepareDetails", javaType = List.class, column = "id", many = @Many(select = "com.siti.material.mapper.PrepareMapper.getByMaterialId")),
    })*/
    List<PrepareVo> getMaterial(@Param("materialType") Integer materialType,@Param("status") Integer status, @Param("createTime")String createTime,@Param("needName") String needName);

    /**
     * 物资表关联
     */
    @Select("<script>" +
            "       select * from prepare_detail where material_id = #{id} " +
            "       <if test=\" needName!=null and needName!=''\"> and needs_name like '%${needName}%' </if>" +
            "</script>")
    List<PrepareDetail> getByMaterialId(@Param("id") Integer id,@Param("needName") String needName);

}
