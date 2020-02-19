package com.siti.hospital.biz;

import com.alibaba.fastjson.JSON;
import com.siti.hospital.mapper.HospitalExampleMapper;
import com.siti.hospital.po.Hospital;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HospitalBiz {

    @Resource
    private HospitalExampleMapper hospitalExampleMapper;



    public static final String HOSPITALLIST = "hospitallist";

    public static final String RK001 = "rk001";

    private static final Logger logger = LoggerFactory.getLogger("HospitalBiz");


    public List<Hospital> selectHospital(String content, Integer hour, Integer orgType) {

                List<Hospital> hospitals = new ArrayList<>();
        try {
            hospitals = hospitalExampleMapper.selectHospital(content, hour, orgType);

        } catch (Exception e) {
                logger.error("查询所有医院错误{}",e.getMessage());
                return null;
            }
        return hospitals;
    }




}
