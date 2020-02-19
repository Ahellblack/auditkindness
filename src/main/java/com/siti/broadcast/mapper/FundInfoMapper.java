package com.siti.broadcast.mapper;

import com.siti.broadcast.po.FundInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface FundInfoMapper extends Mapper<FundInfo> {

    @Update({"UPDATE `fund_info` SET `title`=#{obj.title}, `body`=#{obj.body}, `status`=#{obj.status}, `attachment_link`=#{obj.attachmentLink}" +
            " WHERE (`id`=#{obj.id})"})
    void updateInf(@Param("obj") FundInfo info);

    @Delete({"delete from `fund_info` where id=#{id}"})
    void deleteById(@Param("id") Integer id);
}
