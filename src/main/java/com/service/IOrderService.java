package com.service;

import com.entity.SelectTrain;
import com.entity.ShowResult;
import com.entity.Station;

import java.util.List;

public interface IOrderService {
    List<ShowResult>findAll();

    List<ShowResult>findByLoginName(String loginName);

    void insertorder(ShowResult showResult);

}
