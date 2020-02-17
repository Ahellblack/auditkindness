package com.siti.material.mapper;

import com.siti.material.po.PrepareDetail;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PrepareDetailMapper extends Mapper<PrepareDetail> {

    @Select("SELECT * FROM prepare_detail WHERE material_id=#{materialId};")
    List<PrepareDetail> getAllByMaterialId(int materialId);


}
