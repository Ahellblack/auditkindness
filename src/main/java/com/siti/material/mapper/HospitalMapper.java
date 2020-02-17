package com.siti.material.mapper;

import com.siti.material.po.HospitalEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface HospitalMapper {

    @Select("SELECT id,hospital_name,hospital_address,gaode_lon,gaode_lat from hospital;")
    List<HospitalEntity> getAllPartParam();

    @Update("UPDATE hospital SET " +
            "en_name=#{obj.enHospital}," +
            "en_address=#{obj.enHospitalAddress}," +
            "en_gaode_lon=#{obj.enGaodeLon}," +
            "en_gaode_lat=#{obj.enGaodeLat} " +
            "where id = #{obj.id};")
    int updateHospitalEncryptParam(@Param("obj") HospitalEntity hospitalEntity);

    @Insert("INSERT INTO `hospital` (`province`, `city`, `org_type`, `hospital_name`, `en_name`, `hospital_address`, " +
            "`en_address`, `longitude`, `latitude`, `gaode_lon`, `en_gaode_lon`, `gaode_lat`, `en_gaode_lat`, `class`, " +
            "`type`, `is_lack`, `status`, `org_descr`) VALUES (" +
            " #{obj.province}," +
            " #{obj.city}," +
            " #{obj.orgType}," +
            " #{obj.hospitalName}," +
            " #{obj.enHospital}," +
            " #{obj.hospitalAddress}," +
            " #{obj.enHospitalAddress}," +
            " #{obj.longitude}," +
            " #{obj.latidute}," +
            " #{obj.gaodeLon}," +
            " #{obj.enGaodeLon}, " +
            " #{obj.gaodeLat}," +
            " #{obj.enGaodeLat}," +
            " #{obj.clazz}," +
            " #{obj.type}," +
            " #{obj.isLack}," +
            " #{obj.status}," +
            " #{obj.orgDescr});")
    int insert(@Param("obj") HospitalEntity hospitalEntity);

    @Update("UPDATE `hospital` (`province`, `city`, `org_type`, `hospital_name`, `en_name`, `hospital_address`, " +
            "`en_address`, `longitude`, `latitude`, `gaode_lon`, `en_gaode_lon`, `gaode_lat`, `en_gaode_lat`, " +
            "`class`, `type`, `is_lack`, `status`, `org_descr`) VALUES (" +
            " set `province` = #{obj.province}," +
            " set `city` = #{obj.city}," +
            " set `org_type` = #{obj.orgType}," +
            " set `hospital_name` = #{obj.hospitalName}," +
            " set `en_name` = #{obj.enHospital}," +
            " set `hospital_address` = #{obj.hospitalAddress}," +
            " set `en_address` = #{obj.enHospitalAddress}," +
            " set `longitude` = #{obj.longitude}," +
            " set `latitude` = #{obj.latidute}," +
            " set `gaode_lon` = #{obj.gaodeLon}," +
            " set `en_gaode_lon` = #{obj.enGaodeLon}, " +
            " set `gaode_lat` = #{obj.gaodeLat}," +
            " set `en_gaode_lat` = #{obj.enGaodeLat}," +
            " set `class` = #{obj.clazz}," +
            " set `type` = #{obj.type}," +
            " set `is_lack` = #{obj.isLack}," +
            " set `status` = #{obj.status}," +
            " set `org_descr` = #{obj.orgDescr})" +
            " where id=#{obj.id};")
    int update(@Param("obj") HospitalEntity hospitalEntity);

    @Update("UPDATE `hospital` set " +
            " `province` = #{obj.province}," +
            " `city` = #{obj.city}," +
            " `org_type` = #{obj.orgType}," +
            " `hospital_name` = #{obj.hospitalName}," +
            " `en_name` = #{obj.enHospital}," +
            " `hospital_address` = #{obj.hospitalAddress}," +
            " `en_address` = #{obj.enHospitalAddress}," +
            " `longitude` = #{obj.longitude}," +
            " `latitude` = #{obj.latidute}," +
            " `gaode_lon` = #{obj.gaodeLon}," +
            " `en_gaode_lon` = #{obj.enGaodeLon}, " +
            " `gaode_lat` = #{obj.gaodeLat}," +
            " `en_gaode_lat` = #{obj.enGaodeLat}," +
            " `class` = #{obj.clazz}," +
            " `type` = #{obj.type}," +
            " `is_lack` = #{obj.isLack}," +
            " `status` = #{obj.status}," +
            " `org_descr` = #{obj.orgDescr}" +
            " where hospital_name=#{hospitalName};")
    int updateByName(@Param("obj") HospitalEntity hospitalEntity, @Param("hospitalName") String hospitalName);
    @Select("SELECT * FROM hospital where id=#{id}")
    HospitalEntity getById(int id);

    @Select("SELECT count(*) from hospital where hospital_name=#{hospitalName};")
    int getCountByName(String hospitalName);
}
