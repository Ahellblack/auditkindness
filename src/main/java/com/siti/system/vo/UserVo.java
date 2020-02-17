package com.siti.system.vo;


import com.siti.system.po.User;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by zyw on 2018/1/7.
 */
public class UserVo extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Transient
    private String entryWorkTime;
    @Transient
    private String workAddress;
    @Transient
    private String phoneNum;
    @Transient
    private String companyMailbox;
    @Transient
    private String personalMailbox;


    public String getEntryWorkTime() {
        return entryWorkTime;
    }

    public void setEntryWorkTime(String entryWorkTime) {
        this.entryWorkTime = entryWorkTime;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCompanyMailbox() {
        return companyMailbox;
    }

    public void setCompanyMailbox(String companyMailbox) {
        this.companyMailbox = companyMailbox;
    }

    public String getPersonalMailbox() {
        return personalMailbox;
    }

    public void setPersonalMailbox(String personalMailbox) {
        this.personalMailbox = personalMailbox;
    }

}
