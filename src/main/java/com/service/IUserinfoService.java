package com.service;

import com.entity.Userinfo;

import java.util.List;

public interface IUserinfoService {

    List<Userinfo> findAll();

    List<Userinfo>findNamePassword(Userinfo userinfo);

    Boolean insertUserinfo(Userinfo userinfo);

    void deleteByLoginName(String loginName);

    void updateLoginPassword(Userinfo userinfo);
}
