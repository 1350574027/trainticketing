package com.entity;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class SelectTrain {
    public String chufa;
    public String daoda;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date time;
    public String times;
    public Integer states;

    public SelectTrain() {
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }
}
