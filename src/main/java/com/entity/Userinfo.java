package com.entity;

public class Userinfo {
    private String loginName;
    private String loginPassword;
    private Integer level;
    private Integer state;

    public Userinfo() {
    }

    public Userinfo(String loginName, String loginPassword, Integer level, Integer state) {
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.level = level;
        this.state = state;
    }
    public Userinfo(String loginName, String loginPassword) {
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
