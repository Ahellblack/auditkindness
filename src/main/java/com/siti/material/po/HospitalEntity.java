package com.siti.material.po;


public class HospitalEntity {
    private Integer id;
    private String province;
    private String city;
    private Integer orgType;
    private String hospitalName;
    private String hospitalAddress;
    private String longitude;
    private String latidute;
    private String gaodeLon;
    private String gaodeLat;
    private String clazz;
    private Integer type;
    private Integer isLack;
    private Integer status;
    private Integer encourgeNum;
    private String orgDescr;

    private String enHospital;
    private String enHospitalAddress;
    private String enGaodeLon;
    private String enGaodeLat;

    @Override
    public String toString() {
        return "HospitalEntity{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", orgType=" + orgType +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalAddress='" + hospitalAddress + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latidute='" + latidute + '\'' +
                ", gaodeLon='" + gaodeLon + '\'' +
                ", gaodeLat='" + gaodeLat + '\'' +
                ", clazz='" + clazz + '\'' +
                ", type=" + type +
                ", isLack=" + isLack +
                ", status=" + status +
                ", encourgeNum=" + encourgeNum +
                ", orgDescr='" + orgDescr + '\'' +
                ", enHospital='" + enHospital + '\'' +
                ", enHospitalAddress='" + enHospitalAddress + '\'' +
                ", enGaodeLon='" + enGaodeLon + '\'' +
                ", enGaodeLat='" + enGaodeLat + '\'' +
                '}';
    }

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

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatidute() {
        return latidute;
    }

    public void setLatidute(String latidute) {
        this.latidute = latidute;
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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEncourgeNum() {
        return encourgeNum;
    }

    public void setEncourgeNum(Integer encourgeNum) {
        this.encourgeNum = encourgeNum;
    }

    public String getOrgDescr() {
        return orgDescr;
    }

    public void setOrgDescr(String orgDescr) {
        this.orgDescr = orgDescr;
    }

    public String getEnHospital() {
        return enHospital;
    }

    public void setEnHospital(String enHospital) {
        this.enHospital = enHospital;
    }

    public String getEnHospitalAddress() {
        return enHospitalAddress;
    }

    public void setEnHospitalAddress(String enHospitalAddress) {
        this.enHospitalAddress = enHospitalAddress;
    }

    public String getEnGaodeLon() {
        return enGaodeLon;
    }

    public void setEnGaodeLon(String enGaodeLon) {
        this.enGaodeLon = enGaodeLon;
    }

    public String getEnGaodeLat() {
        return enGaodeLat;
    }

    public void setEnGaodeLat(String enGaodeLat) {
        this.enGaodeLat = enGaodeLat;
    }
}
