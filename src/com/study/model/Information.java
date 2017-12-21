package com.study.model;

import java.sql.Date;
import java.util.Arrays;

/**
 * Created by asus on 2017/12/19.
 */
public class Information {
    private String account ;
    private String name ;
    private Integer departmentID ;
    private String education ;
    private String gender ;
    private Date birthday ;
    private byte[] avatar ;
    private String telephone ;
    private String address ;
    private Date entryTime ;

    public Information(String account, String name, Integer departmentID, String education, String gender, Date birthday, byte[] avatar, String telephone, String address, Date entryTime) {
        this.account = account;
        this.name = name;
        this.departmentID = departmentID;
        this.education = education;
        this.gender = gender;
        this.birthday = birthday;
        this.avatar = avatar;
        this.telephone = telephone;
        this.address = address;
        this.entryTime = entryTime;
    }

    public Information() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "information{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", departmentID=" + departmentID +
                ", education='" + education + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", avatar=" + Arrays.toString(avatar) +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", entryTime=" + entryTime +
                '}';
    }
}
