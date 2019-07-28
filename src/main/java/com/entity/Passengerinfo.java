package com.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
public class Passengerinfo {
    private Integer id;
    @NotEmpty(message = "乘客名不能为空")
    @Size(min = 2,max = 5,message = "乘客名的长度必须在{min}-{max}之间")
    private String passengername;
    @NotEmpty(message = "身份证号不能为空")
    @Size(min = 18,max = 18,message = "身份证号必须是十八位")
    private String idcard;
    private String adult;
    private String passengerpicture;
    private String loginName;

    public Passengerinfo() {
    }

    public Passengerinfo(String loginName) {
        this.loginName = loginName;
    }

    public Passengerinfo(String passengername, String idcard, String adult, String passengerpicture) {
        this.passengername = passengername;
        this.idcard = idcard;
        this.adult = adult;
        this.passengerpicture = passengerpicture;
    }

    public Passengerinfo(Integer id, String passengername, String idcard, String adult, String passengerpicture) {
        this.id = id;
        this.passengername = passengername;
        this.idcard = idcard;
        this.adult = adult;
        this.passengerpicture = passengerpicture;
    }

    public Passengerinfo(String passengername, String idcard, String adult, String passengerpicture, String loginName) {
        this.passengername = passengername;
        this.idcard = idcard;
        this.adult = adult;
        this.passengerpicture = passengerpicture;
        this.loginName = loginName;
    }

    public Passengerinfo(Integer id, String passengername, String idcard, String adult, String passengerpicture, String loginName) {
        this.id = id;
        this.passengername = passengername;
        this.idcard = idcard;
        this.adult = adult;
        this.passengerpicture = passengerpicture;
        this.loginName = loginName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassengername() {
        return passengername;
    }

    public void setPassengername(String passengername) {
        this.passengername = passengername;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getPassengerpicture() {
        return passengerpicture;
    }

    public void setPassengerpicture(String passengerpicture) {
        this.passengerpicture = passengerpicture;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
