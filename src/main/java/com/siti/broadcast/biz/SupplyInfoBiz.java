package com.siti.broadcast.biz;

import com.siti.broadcast.mapper.SupplyInfoMapper;
import com.siti.broadcast.po.SupplyInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SupplyInfoBiz {

    @Resource
    SupplyInfoMapper supplyInfoMapper;

    /**
     * 添加*/
    public int insert(SupplyInfo info) {
        return supplyInfoMapper.insert(info);
    }

    /**
     * 修改*/
    public void update(SupplyInfo info) {
        supplyInfoMapper.updateInf(info);
    }

    /**
     * 删除*/
    public void delete(Integer id) {
        supplyInfoMapper.deleteById(id);
    }
}
