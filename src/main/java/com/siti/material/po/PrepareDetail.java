package com.siti.material.po;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "prepare_detail")
public class PrepareDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//主键
	private Integer materialId;//需求id,关联supplies_publish表的id
	private String needsName;//需求物
	private String needsNum;//需求数量
	private String descr;//描述
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
	public String getNeedsName() {
		return needsName;
	}
	public void setNeedsName(String needsName) {
		this.needsName = needsName;
	}
	public String getNeedsNum() {
		return needsNum;
	}
	public void setNeedsNum(String needsNum) {
		this.needsNum = needsNum;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
}
