package com.siti.broadcast.mapper;

import com.siti.broadcast.po.PurchaseDemand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface PurchaseDemandMapper extends Mapper<PurchaseDemand> {

    @Update({"UPDATE `purchase_demand` SET `title`=#{obj.title}, `body`=#{obj.body}, `status`=#{obj.status}, `attachment_link`=#{obj.attachmentLink}" +
            " WHERE (`id`=#{obj.id})"})
    void updateInf(@Param("obj") PurchaseDemand demand);

    @Delete({"delete from `purchase_demand` where id=#{id}"})
    void deleteById(@Param("id") Integer id);
}
