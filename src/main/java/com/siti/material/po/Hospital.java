package com.siti.material.po;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "hospital")
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//主键
	private String province;//省
	private String city;//市
	private Integer orgType;//组织种类：1需求方，2提供方，3公益组织
	private String hospitalName;//医院名称
	private String hospitalAddress;//医院地址
	private BigDecimal longitude;//经度
	private BigDecimal latitude;//纬度
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
	private String needsName;//需求物
	@Transient
	private String needsDescr;//描述
	@Transient
	private String lnglat;//拼接经纬度
	@Transient
	private Integer orgStatus;//组织类型
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getIsLack() {
		return isLack;
	}
	public void setIsLack(Integer isLack) {
		this.isLack = isLack;
	}
	public Integer getEncourageNum() {
		return encourageNum;
	}
	public void setEncourageNum(Integer encourageNum) {
		this.encourageNum = encourageNum;
	}
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	public String getLinkPeople() {
		return linkPeople;
	}
	public void setLinkPeople(String linkPeople) {
		this.linkPeople = linkPeople;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSourceLink() {
		return sourceLink;
	}
	public void setSourceLink(String sourceLink) {
		this.sourceLink = sourceLink;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getNeedsName() {
		return needsName;
	}
	public void setNeedsName(String needsName) {
		this.needsName = needsName;
	}
	public String getNeedsDescr() {
		return needsDescr;
	}
	public void setNeedsDescr(String needsDescr) {
		this.needsDescr = needsDescr;
	}
	public String getGaodeLon() {
		return gaodeLon;
	}
	public void setGaodeLon(String gaodeLon) {
		this.gaodeLon = gaodeLon;
	}
	public String getGaodeLat() {
		return gaodeLat;
	}
	public void setGaodeLat(String gaodeLat) {
		this.gaodeLat = gaodeLat;
	}
	public Integer getOrgType() {
		return orgType;
	}
	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}
	public String getOrgDescr() {
		return orgDescr;
	}
	public void setOrgDescr(String orgDescr) {
		this.orgDescr = orgDescr;
	}
	public String getLnglat() {
		return lnglat;
	}
	public void setLnglat(String lnglat) {
		this.lnglat = lnglat;
	}
	public Integer getOrgStatus() {
		return orgStatus;
	}
	public void setOrgStatus(Integer orgStatus) {
		this.orgStatus = orgStatus;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
