package com.siti.broadcast.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siti.broadcast.mapper.DonateMapper;
import com.siti.broadcast.po.Donate;
import com.siti.broadcast.vo.DonateVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DonateBiz {

    @Resource
    private DonateMapper donateMapper;

    public PageInfo<DonateVo> getDonateInfo(String headline, String startDate, String endDate, Integer isTop,
                                            Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<DonateVo> info = donateMapper.getDonateInfo(headline, startDate, endDate, isTop);
        PageInfo<DonateVo> pageInfo = new PageInfo<>(info);
        return pageInfo;
    }

    /**
     * 添加*/
    public int insert(Donate donate) {
        return donateMapper.insert(donate);
    }

    /**
     * 修改*/
    public void update(Donate donate) {
        donateMapper.updateInf(donate);
    }

    /**
     * 删除*/
    public void delete(Integer id) {
        donateMapper.deleteById(id);
    }
}
