package com.dao;

import com.entity.ShowResult;

import java.util.List;

public interface OrderMapper {
    List<ShowResult>findAll();

    List<ShowResult>findByLoginName(String loginName);

    void insertorder(ShowResult showResult);



}
