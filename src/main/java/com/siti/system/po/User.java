package com.siti.system.po;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Table(name = "sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String realName;
    private String password;
    private String sex;
    private String image;
    private BigDecimal longitude;//经度
    private BigDecimal latitude;//纬度
    private String towncode;
    private String countycode;
    private Date lastTime;//最近上传位置时间

    @Transient
    private String imageURL;
    private String idCard;   //  身份证号
    private String emailAddr;     //邮箱地址
    private String phoneNum;   //  手机号码
    @Transient
    private Integer mainOrg;// 主职组织
    @Transient
    private String orgPath;// 组织路径
    @Transient
    private String orgName; //所负责组织
    @Transient
    private Integer roleId; // 主要角色ID
    private String roleCode; // 主要角色
    @Transient
    private String roleName; // 主要角色
    @Transient
    private String majorRegion; // 负责区域
    @Transient
    private String areas; // 负责区域
    private Integer status;    // 用户状态：0：已删除；1：有效；2：冻结'
    private Integer updateBy;    //操作用户ID
    private String pushId; // 推送ID
    @Transient
    private String updateName;    //操作用户
    private Date updateTime;    //更新时间
    private String remark;  // 备注信息
    @Transient
    private List<Role> roles;
    @Transient
    private Integer canUpdate;   // 是否可删除
    @Transient
    private Integer canDelete;    //  是否可修改


    public User() {
    }

    public User(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.realName = user.getRealName();
        this.password = user.getPassword();
        this.sex = user.getSex();
        this.image = user.getImage();
        this.imageURL = user.getImageURL();
        this.idCard = user.getIdCard();
        this.phoneNum = user.getPhoneNum();
        this.mainOrg = user.getMainOrg();
        this.majorRegion = user.getMajorRegion();
        this.orgName = user.getOrgName();
        this.roleCode = user.getRoleCode();
        this.roleId = user.getRoleId();
        this.status = user.getStatus();
        this.updateBy = user.getUpdateBy();
        this.updateTime = user.getUpdateTime();
        this.pushId = user.getPushId();
        this.updateName = user.getUpdateName();
        this.remark = user.getRemark();
        this.roles = user.getRoles();
        this.emailAddr = user.getEmailAddr();
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

    public String getTowncode() {
        return towncode;
    }

    public void setTowncode(String towncode) {
        this.towncode = towncode;
    }

    public String getCountycode() {
        return countycode;
    }

    public void setCountycode(String countycode) {
        this.countycode = countycode;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public Integer getCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(Integer canUpdate) {
        this.canUpdate = canUpdate;
    }

    public Integer getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Integer canDelete) {
        this.canDelete = canDelete;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public Integer getMainOrg() {
        return mainOrg;
    }

    public void setMainOrg(Integer mainOrg) {
        this.mainOrg = mainOrg;
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath;
    }

    public String getMajorRegion() {
        return majorRegion;
    }

    public void setMajorRegion(String majorRegion) {
        this.majorRegion = majorRegion;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }
}
