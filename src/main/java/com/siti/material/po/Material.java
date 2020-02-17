package com.siti.material.po;


import com.siti.material.vo.ImgByteVo;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "material")
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//主键
	private Integer materialType;//1需求方，2提供方
	private String province;//省
	private String city;//市
	private String name;//名称
	private String address;//地址
	private String longitude;//经度
	private String latitude;//纬度
	private String serviceRange;//服务覆盖范围
	private Integer type;//机构类型, 1民间组织，2志愿者团队，3企业，4定点医院，5发热门诊，6防控指挥部，7普通医院，8个人，9公益组织，10海外组织
	private String status;//1接受个人捐赠、2接受企业捐赠、3接受采购、4捐赠、5采购
	private String linkPeople;//联系人-联系电话，逗号分隔
	private String startTime;//服务起始时间
	private String endTime;//服务结束时间
	private String createTime;//发布时间
	private Integer source;//需求来源,1政府发布、2医院官方渠道、3公益平台、4微信公众号、5其他
	private Integer sourceLink;//需求链接
	private String picUrl;//需求证明材料地址，逗号分隔
	private Integer isLogistics;//是否需要物流，0否，1是
	private String descr;//备注
	private String needsDescr;//需求物/服务备注
	private Date updateTime;//录入时间
	@Transient
	private List<MaterialDetail> materialDetails;//需求明细
	@Transient
	private MultipartFile[] files;//文件
	@Transient
	private List<ImgByteVo> ImgBytes;//文件
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMaterialType() {
		return materialType;
	}
	public void setMaterialType(Integer materialType) {
		this.materialType = materialType;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getLinkPeople() {
		return linkPeople;
	}
	public void setLinkPeople(String linkPeople) {
		this.linkPeople = linkPeople;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public List<MaterialDetail> getMaterialDetails() {
		return materialDetails;
	}
	public void setMaterialDetails(List<MaterialDetail> materialDetails) {
		this.materialDetails = materialDetails;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public MultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getSourceLink() {
		return sourceLink;
	}
	public void setSourceLink(Integer sourceLink) {
		this.sourceLink = sourceLink;
	}
	public String getServiceRange() {
		return serviceRange;
	}
	public void setServiceRange(String serviceRange) {
		this.serviceRange = serviceRange;
	}
	public Integer getIsLogistics() {
		return isLogistics;
	}
	public void setIsLogistics(Integer isLogistics) {
		this.isLogistics = isLogistics;
	}
	public List<ImgByteVo> getImgBytes() {
		return ImgBytes;
	}
	public void setImgBytes(List<ImgByteVo> imgBytes) {
		ImgBytes = imgBytes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNeedsDescr() {
		return needsDescr;
	}
	public void setNeedsDescr(String needsDescr) {
		this.needsDescr = needsDescr;
	}
	
}
