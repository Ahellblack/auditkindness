package com.siti.hospital.mapper;

import com.siti.hospital.po.Hospital;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HospitalExampleMapper extends Mapper<Hospital>{

	@Select({"<script>",
        " SELECT a.id,a.province,a.city,a.org_type,a.en_name as hospitalName,a.en_address as hospitalAddress,a.en_gaode_lon as gaodeLon,a.en_gaode_lat as gaodeLat,a.type,a.is_lack,a.status,a.encourage_num,a.org_descr, "
        + "b.link_address,d.en_people as linkPeople,d.en_tel_x as linkTel,DATE_FORMAT(b.create_time,'%Y-%m-%d %T') as createTime,b.source,b.source_link,b.descr,c.needs_name as needsName,c.needsDescr,if(a.is_lack=1,if(a.type=0,1,(if(a.type=1,2,3))),if(a.type=0,4,(if(a.type=1,5,6)))) as orgStatus "
        + "FROM hospital a left join (select * from (SELECT * FROM supplies_publish where DATE_SUB(CURDATE(), INTERVAL 31 DAY) &lt;= date(create_time) order by create_time desc) e group by e.hospital_name) b on a.hospital_name=b.hospital_name "
        + "left join (SELECT publish_id,GROUP_CONCAT(DISTINCT needs_name) as needs_name,GROUP_CONCAT(CONCAT(needs_name,':',descr)) as needsDescr FROM supplies_publish_detail group by publish_id) c on b.id=c.publish_id "
        + "left join (SELECT publish_id,GROUP_CONCAT(en_people) as en_people,GROUP_CONCAT(en_tel_x) as en_tel_x FROM supplies_publish_call group by publish_id) d on b.id=d.publish_id where 1=1 "
        + "<if test=\"content!=null\"> and (a.hospital_name like concat(concat('%',#{content}),'%') or a.province like concat(concat('%',#{content}),'%') or a.city like concat(concat('%',#{content}),'%') or c.needs_name like concat(concat('%',#{content}),'%'))</if> "
        + "<if test=\"hour!=null\"> and b.create_time >=(now() - interval #{hour} hour)</if>"
        + "<if test=\"orgType!=null\"> and a.org_type=#{orgType}</if>"
        + "group by a.hospital_name order by b.create_time desc"+
        "</script>"})
	List<Hospital> selectHospital(@Param("content") String content, @Param("hour") Integer hour, @Param("orgType") Integer orgType);


}
