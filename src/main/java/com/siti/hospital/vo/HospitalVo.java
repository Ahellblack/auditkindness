package com.siti.hospital.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 12293 on 2020/2/20.
 */
public class HospitalVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//主键
    private String province;//省
    private String city;//市
    private Integer orgType;//组织种类：1需求方，2提供方，3公益组织
    private String hospitalName;//医院名称
    private String hospitalAddress;//医院地址
    private String longitude;//经度
    private String latitude;//纬度
    private String gaodeLon;//高德经度
    private String gaodeLat;//高德纬度
    private Integer type;//医院类别（1:新冠状病毒肺炎定点医疗机构/2:发热门诊定点机构/0:普通医疗机构）
    private Integer isLack;//是否缺物资,1:是
    private Integer status;//供应商营业状态1、正常经营 2、政府托管 3、尚未核实
    private Integer encourageNum;//点赞数
    private String orgDescr;//备注

    @Transient
    private String linkAddress;//联系地址
    @Transient
    private String linkPeople;//联系人，逗号分隔
    @Transient
    private String linkTel;//联系电话，逗号分隔
    @Transient
    private String source;//来源
    @Transient
    private String sourceLink;//来源原文链接
    @Transient
    private String descr;//备注
    @Transient
    private String createTime;//发布时间
    @Transient
    private List<String> needsNameList;//需求物
    @Transient
    private String needsDescr;//描述
    @Transient
    private String lnglat;//拼接经纬度
    @Transient
    private Integer orgStatus;//组织类型

    private String needsName;//需求物


    public Integer getId() {
        return id;
    }

    public HospitalVo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public HospitalVo setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public HospitalVo setCity(String city) {
        this.city = city;
        return this;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public HospitalVo setOrgType(Integer orgType) {
        this.orgType = orgType;
        return this;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public HospitalVo setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
        return this;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public HospitalVo setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public HospitalVo setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public HospitalVo setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getGaodeLon() {
        return gaodeLon;
    }

    public HospitalVo setGaodeLon(String gaodeLon) {
        this.gaodeLon = gaodeLon;
        return this;
    }

    public String getGaodeLat() {
        return gaodeLat;
    }

    public HospitalVo setGaodeLat(String gaodeLat) {
        this.gaodeLat = gaodeLat;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public HospitalVo setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getIsLack() {
        return isLack;
    }

    public HospitalVo setIsLack(Integer isLack) {
        this.isLack = isLack;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public HospitalVo setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getEncourageNum() {
        return encourageNum;
    }

    public HospitalVo setEncourageNum(Integer encourageNum) {
        this.encourageNum = encourageNum;
        return this;
    }

    public String getOrgDescr() {
        return orgDescr;
    }

    public HospitalVo setOrgDescr(String orgDescr) {
        this.orgDescr = orgDescr;
        return this;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public HospitalVo setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
        return this;
    }

    public String getLinkPeople() {
        return linkPeople;
    }

    public HospitalVo setLinkPeople(String linkPeople) {
        this.linkPeople = linkPeople;
        return this;
    }

    public String getLinkTel() {
        return linkTel;
    }

    public HospitalVo setLinkTel(String linkTel) {
        this.linkTel = linkTel;
        return this;
    }

    public String getSource() {
        return source;
    }

    public HospitalVo setSource(String source) {
        this.source = source;
        return this;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public HospitalVo setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
        return this;
    }

    public String getDescr() {
        return descr;
    }

    public HospitalVo setDescr(String descr) {
        this.descr = descr;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public HospitalVo setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public List<String> getNeedsNameList() {
        return needsNameList;
    }

    public HospitalVo setNeedsNameList(List<String> needsNameList) {
        this.needsNameList = needsNameList;
        return this;
    }

    public String getNeedsName() {
        return needsName;
    }

    public HospitalVo setNeedsName(String needsName) {
        this.needsName = needsName;
        return this;
    }

    public String getNeedsDescr() {
        return needsDescr;
    }

    public HospitalVo setNeedsDescr(String needsDescr) {
        this.needsDescr = needsDescr;
        return this;
    }

    public String getLnglat() {
        return lnglat;
    }

    public HospitalVo setLnglat(String lnglat) {
        this.lnglat = lnglat;
        return this;
    }

    public Integer getOrgStatus() {
        return orgStatus;
    }

    public HospitalVo setOrgStatus(Integer orgStatus) {
        this.orgStatus = orgStatus;
        return this;
    }
}
