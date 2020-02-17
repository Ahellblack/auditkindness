package com.siti.material.mapper;

import com.siti.material.po.SuppliesPublishDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SuppliesPublishDetailMapper {

    @Insert("INSERT INTO `supplies_publish_detail` (`publish_id`, `needs_name`, `descr`) VALUES (" +
            " #{obj.publishId},  #{obj.needsName},  #{obj.descr})")
    int insert(@Param("obj") SuppliesPublishDetail suppliesPublishDetail);


    @Select("select * from supplies_publish_detail where needs_name=#{obj.needsName} and publish_id=#{obj.publishId};")
    SuppliesPublishDetail getByParams(@Param("obj") SuppliesPublishDetail suppliesPublishDetail);


    @Update("update supplies_publish_detail set descr=#{obj.descr} where needs_name=#{obj.needsName} " +
            "and publish_id=#{obj.publishId} ;")
    int updateDescr(@Param("obj") SuppliesPublishDetail suppliesPublishDetail);
}
