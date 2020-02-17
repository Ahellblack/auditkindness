package com.siti.material.po;

/**
 * @program: springbootvue
 * @description:
 * @author: Que Zhixing
 * @create: 2020-02-11 22:28
 **/
public class SuppliesPublishCall {
    private Integer id;
    private Integer publishId;
    private String linkPeople;
    private String enPeople;
    private String linktel;
    private String texX;
    private String enTelX;
    private Integer isTrue;

    @Override
    public String toString() {
        return "SuppliesPublishCall{" +
                "id=" + id +
                ", publishId=" + publishId +
                ", linkPeople='" + linkPeople + '\'' +
                ", enPeople='" + enPeople + '\'' +
                ", linktel='" + linktel + '\'' +
                ", texX='" + texX + '\'' +
                ", enTelX='" + enTelX + '\'' +
                ", isTrue=" + isTrue +
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

    public String getLinkPeople() {
        return linkPeople;
    }

    public void setLinkPeople(String linkPeople) {
        this.linkPeople = linkPeople;
    }

    public String getEnPeople() {
        return enPeople;
    }

    public void setEnPeople(String enPeople) {
        this.enPeople = enPeople;
    }

    public String getLinktel() {
        return linktel;
    }

    public void setLinktel(String linktel) {
        this.linktel = linktel;
    }

    public String getTexX() {
        return texX;
    }

    public void setTexX(String texX) {
        this.texX = texX;
    }

    public String getEnTelX() {
        return enTelX;
    }

    public void setEnTelX(String enTelX) {
        this.enTelX = enTelX;
    }

    public Integer getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(Integer isTrue) {
        this.isTrue = isTrue;
    }
}
