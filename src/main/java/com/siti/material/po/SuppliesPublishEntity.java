package com.siti.material.po;

import java.sql.Timestamp;


public class SuppliesPublishEntity {
    private Integer id;
    private String hopistalName;
    private String linkAddress;
    private String linkPeople;
    private String linkTel;
    private Timestamp createTime;
    private String source;
    private String sourceLink;
    private String descr;

    private String enLinkPeople;
    private String enLinkTel;

    @Override
    public String toString() {
        return "SuppliesPublishEntity{" +
                "id=" + id +
                ", hopistalName='" + hopistalName + '\'' +
                ", linkAddress='" + linkAddress + '\'' +
                ", linkPeople='" + linkPeople + '\'' +
                ", linkTel='" + linkTel + '\'' +
                ", createTime=" + createTime +
                ", source='" + source + '\'' +
                ", sourceLink='" + sourceLink + '\'' +
                ", descr='" + descr + '\'' +
                ", enLinkPeople='" + enLinkPeople + '\'' +
                ", enLinkTel='" + enLinkTel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHopistalName() {
        return hopistalName;
    }

    public void setHopistalName(String hopistalName) {
        this.hopistalName = hopistalName;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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

    public String getEnLinkPeople() {
        return enLinkPeople;
    }

    public void setEnLinkPeople(String enLinkPeople) {
        this.enLinkPeople = enLinkPeople;
    }

    public String getEnLinkTel() {
        return enLinkTel;
    }

    public void setEnLinkTel(String enLinkTel) {
        this.enLinkTel = enLinkTel;
    }
}
