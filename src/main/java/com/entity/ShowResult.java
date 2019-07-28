package com.entity;

import javax.xml.crypto.Data;
import java.security.PublicKey;
import java.util.Date;

public class ShowResult {
    public String chufa;
    public String daoda;
    public Date chufatime;
    public Date daodatime;
    public Date needtime;
    public String trainid;
    public Float chufamoney;
    public Float daodamoney;
    public Float needmoney;
    public Float needmoney1;
    public Integer trainstate;
    public Integer carriageid;
    public Integer seatid;
    public String seat;
    public Integer liness;
    public String loginName;

    public ShowResult() {
    }

    public String getChufa() {
        return chufa;
    }

    public void setChufa(String chufa) {
        this.chufa = chufa;
    }

    public String getDaoda() {
        return daoda;
    }

    public void setDaoda(String daoda) {
        this.daoda = daoda;
    }

    public Date getChufatime() {
        return chufatime;
    }

    public void setChufatime(Date chufatime) {
        this.chufatime = chufatime;
    }

    public Date getDaodatime() {
        return daodatime;
    }

    public void setDaodatime(Date daodatime) {
        this.daodatime = daodatime;
    }

    public Date getNeedtime() {
        return needtime;
    }

    public void setNeedtime(Date needtime) {
        this.needtime = needtime;
    }

    public String getTrainid() {
        return trainid;
    }

    public void setTrainid(String trainid) {
        this.trainid = trainid;
    }

    public Float getNeedmoney() {
        needmoney = daodamoney-chufamoney;
        return needmoney;
    }

    public Float getChufamoney() {
        return chufamoney;
    }

    public void setChufamoney(Float chufamoney) {
        this.chufamoney = chufamoney;
    }

    public Float getDaodamoney() {
        return daodamoney;
    }

    public void setDaodamoney(Float daodamoney) {
        this.daodamoney = daodamoney;
    }

    public Integer getTrainstate() {
        return trainstate;
    }

    public void setTrainstate(Integer trainstate) {
        this.trainstate = trainstate;
    }

    public Integer getCarriageid() {
        return carriageid;
    }

    public void setCarriageid(Integer carriageid) {
        this.carriageid = carriageid;
    }

    public Integer getSeatid() {
        return seatid;
    }

    public void setSeatid(Integer seatid) {
        this.seatid = seatid;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Integer getLiness() {
        return liness;
    }

    public void setLiness(Integer liness) {
        this.liness = liness;
    }

    public void setNeedmoney(Float needmoney) {
        this.needmoney = needmoney;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Float getNeedmoney1() {
        return needmoney1;
    }

    public void setNeedmoney1(Float needmoney1) {
        this.needmoney1 = needmoney1;
    }
}
