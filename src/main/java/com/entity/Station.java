package com.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

public class Station {
    public Integer id;
    public String trainid;
    public Integer trainstate;
    public String stationname;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date arrivaltime;
    public Integer departure;
    public Integer terminus;
    public Float price;
    public Station() {
    }

    public Integer gettrainstate() {
        return trainstate;
    }

    public void settrainstate(Integer trainstate) {
        this.trainstate = trainstate;
    }

    public Integer getid() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettrainid() {
        return trainid;
    }

    public void settrainid(String trainid) {
        this.trainid = trainid;
    }

    public String getstationname() {
        return stationname;
    }

    public void setstationname(String stationname) {
        this.stationname = stationname;
    }

    public Date getarrivaltime() {
        return arrivaltime;
    }

    public void setarrivaltime(Date arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public Integer getdeparture() {
        return departure;
    }

    public void setdeparture(Integer departure) {
        this.departure = departure;
    }

    public Integer getterminus() {
        return terminus;
    }

    public void setterminus(Integer terminus) {
        this.terminus = terminus;
    }

    public Float getprice() {
        return price;
    }

    public void setprice(Float price) {
        this.price = price;
    }
}
