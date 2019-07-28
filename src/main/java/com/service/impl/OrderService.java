package com.service.impl;

import com.dao.IndexMapper;
import com.dao.OrderMapper;
import com.entity.SelectTrain;
import com.entity.ShowResult;
import com.entity.Station;
import com.service.IIndexService;
import com.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<ShowResult>findAll(){
        List<ShowResult>list = orderMapper.findAll();
        return list;
    }

    @Override
    public List<ShowResult>findByLoginName(String loginName){
        List<ShowResult>list = orderMapper.findByLoginName(loginName);
        return list;
    }

    @Override
    public void insertorder(ShowResult showResult){
        orderMapper.insertorder(showResult);
    }

}
