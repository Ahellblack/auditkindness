package com.siti.broadcast.biz;

import com.siti.broadcast.mapper.PurchaseDemandMapper;
import com.siti.broadcast.po.PurchaseDemand;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PurchaseDemandBiz {

    @Resource
    PurchaseDemandMapper purchaseDemandMapper;

    /**
     * 添加*/
    public int insert(PurchaseDemand info) {
        return purchaseDemandMapper.insert(info);
    }

    /**
     * 修改*/
    public void update(PurchaseDemand info) {
        purchaseDemandMapper.updateInf(info);
    }

    /**
     * 删除*/
    public void delete(Integer id) {
        purchaseDemandMapper.deleteById(id);
    }
}
