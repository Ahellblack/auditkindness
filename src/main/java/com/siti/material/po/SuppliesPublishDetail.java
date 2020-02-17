package com.siti.material.po;

/**
 * @program: springbootvue
 * @description:
 * @author: Que Zhixing
 * @create: 2020-02-11 22:22
 **/
public class SuppliesPublishDetail {
    private Integer id;
    private Integer publishId;
    private String needsName;
    private String descr;

    @Override
    public String toString() {
        return "SuppliesPublishDetail{" +
                "id=" + id +
                ", publishId=" + publishId +
                ", needsName='" + needsName + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public String getNeedsName() {
        return needsName;
    }

    public void setNeedsName(String needsName) {
        this.needsName = needsName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
