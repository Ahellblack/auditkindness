package com.siti.hospital.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siti.hospital.mapper.HospitalExampleMapper;
import com.siti.hospital.po.Hospital;
import com.siti.hospital.vo.HospitalVo;
import com.siti.utils.AESUtil;
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


    public PageInfo<HospitalVo> selectHospital(Integer page, Integer pageSize, String content, String startTime, String endTime, Integer orgType) {


        try {
            PageHelper.startPage(page, pageSize);
            List<HospitalVo> hospitals = hospitalExampleMapper.selectHospital(content, startTime, endTime, orgType);
            hospitals.forEach(data->{
                try {
                    if(data.getHospitalName()!=null && data.getHospitalName()!="")
                    data.setHospitalName(AESUtil.Decrypt(data.getHospitalName()));
                    if(data.getHospitalAddress()!=null && data.getHospitalAddress()!="")
                        data.setHospitalAddress(AESUtil.Decrypt(data.getHospitalAddress()));
                    if(data.getGaodeLat()!=null && data.getGaodeLat()!="")
                        data.setGaodeLat(AESUtil.Decrypt(data.getGaodeLat()));
                    if(data.getGaodeLon()!=null && data.getGaodeLon()!="")
                        data.setGaodeLon(AESUtil.Decrypt(data.getGaodeLon()));
                    if(data.getLinkPeople()!=null && data.getLinkPeople()!="") {
                        String[] splitLinkPeople = data.getLinkPeople().split(",");
                        StringBuffer linkPeople = new StringBuffer();
                        for(String people:splitLinkPeople){
                            linkPeople.append(AESUtil.Decrypt(people));
                        }
                        data.setLinkPeople(linkPeople.toString());
                    }
                    if(data.getLinkTel()!=null && data.getLinkTel()!="") {
                        String[] splitLinkTel = data.getLinkTel().split(",");
                        StringBuffer LinkTel = new StringBuffer();
                        for(String tel:splitLinkTel){
                            LinkTel.append(AESUtil.Decrypt(tel));
                        }
                        data.setLinkTel(LinkTel.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            PageInfo<HospitalVo> pageInfo = new PageInfo<>(hospitals);
            return pageInfo;
        } catch (Exception e) {
            logger.error("查询所有医院错误{}", e.getMessage());
            return null;
        }

    }


}
