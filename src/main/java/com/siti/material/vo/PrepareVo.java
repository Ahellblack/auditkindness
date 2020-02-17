package com.siti.material.vo;

import com.siti.material.po.MaterialDetail;
import com.siti.material.po.PrepareDetail;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class PrepareVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;//主键
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
	private List<MaterialDetail> materialDetails;//需求明细
	private MultipartFile[] files;//文件
	private List<ImgByteVo> ImgBytes;//文件
	private List<PrepareDetail> prepareDetails;

	private Integer isDelete;//是否已刪除
	private Integer isAudit;//是否已審核

	public Integer getIsDelete() {
		return isDelete;
	}

	public PrepareVo setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
		return this;
	}

	public Integer getIsAudit() {
		return isAudit;
	}

	public PrepareVo setIsAudit(Integer isAudit) {
		this.isAudit = isAudit;
		return this;
	}

	public int getId() {
		return id;
	}

	public PrepareVo setId(int id) {
		this.id = id;
		return this;
	}

	public List<PrepareDetail> getPrepareDetails() {
		return prepareDetails;
	}

	public PrepareVo setPrepareDetails(List<PrepareDetail> prepareDetails) {
		this.prepareDetails = prepareDetails;
		return this;
	}

	public Integer getMaterialType() {
		return materialType;
	}

	public PrepareVo setMaterialType(Integer materialType) {
		this.materialType = materialType;
		return this;
	}

	public String getProvince() {
		return province;
	}

	public PrepareVo setProvince(String province) {
		this.province = province;
		return this;
	}

	public String getCity() {
		return city;
	}

	public PrepareVo setCity(String city) {
		this.city = city;
		return this;
	}

	public String getName() {
		return name;
	}

	public PrepareVo setName(String name) {
		this.name = name;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public PrepareVo setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getLongitude() {
		return longitude;
	}

	public PrepareVo setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}

	public String getLatitude() {
		return latitude;
	}

	public PrepareVo setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}

	public String getServiceRange() {
		return serviceRange;
	}

	public PrepareVo setServiceRange(String serviceRange) {
		this.serviceRange = serviceRange;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public PrepareVo setType(Integer type) {
		this.type = type;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public PrepareVo setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getLinkPeople() {
		return linkPeople;
	}

	public PrepareVo setLinkPeople(String linkPeople) {
		this.linkPeople = linkPeople;
		return this;
	}

	public String getStartTime() {
		return startTime;
	}

	public PrepareVo setStartTime(String startTime) {
		this.startTime = startTime;
		return this;
	}

	public String getEndTime() {
		return endTime;
	}

	public PrepareVo setEndTime(String endTime) {
		this.endTime = endTime;
		return this;
	}

	public String getCreateTime() {
		return createTime;
	}

	public PrepareVo setCreateTime(String createTime) {
		this.createTime = createTime;
		return this;
	}

	public Integer getSource() {
		return source;
	}

	public PrepareVo setSource(Integer source) {
		this.source = source;
		return this;
	}

	public Integer getSourceLink() {
		return sourceLink;
	}

	public PrepareVo setSourceLink(Integer sourceLink) {
		this.sourceLink = sourceLink;
		return this;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public PrepareVo setPicUrl(String picUrl) {
		this.picUrl = picUrl;
		return this;
	}

	public Integer getIsLogistics() {
		return isLogistics;
	}

	public PrepareVo setIsLogistics(Integer isLogistics) {
		this.isLogistics = isLogistics;
		return this;
	}

	public String getDescr() {
		return descr;
	}

	public PrepareVo setDescr(String descr) {
		this.descr = descr;
		return this;
	}

	public String getNeedsDescr() {
		return needsDescr;
	}

	public PrepareVo setNeedsDescr(String needsDescr) {
		this.needsDescr = needsDescr;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public PrepareVo setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public List<MaterialDetail> getMaterialDetails() {
		return materialDetails;
	}

	public PrepareVo setMaterialDetails(List<MaterialDetail> materialDetails) {
		this.materialDetails = materialDetails;
		return this;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public PrepareVo setFiles(MultipartFile[] files) {
		this.files = files;
		return this;
	}

	public List<ImgByteVo> getImgBytes() {
		return ImgBytes;
	}

	public PrepareVo setImgBytes(List<ImgByteVo> imgBytes) {
		ImgBytes = imgBytes;
		return this;
	}
}
