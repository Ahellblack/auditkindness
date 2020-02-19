package com.siti.broadcast.biz;

import com.siti.broadcast.mapper.FundInfoMapper;
import com.siti.broadcast.po.FundInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FundInfoBiz {

    @Resource
    FundInfoMapper fundInfoMapper;

    /**
     * 添加*/
    public int insert(FundInfo info) {
        return fundInfoMapper.insert(info);
    }

    /**
     * 修改*/
    public void update(FundInfo info) {
        fundInfoMapper.updateInf(info);
    }

    /**
     * 删除*/
    public void delete(Integer id) {
        fundInfoMapper.deleteById(id);
    }
}
