package com.service.impl;

import com.dao.PassengerinfoMapper;
import com.entity.Passengerinfo;
import com.service.IPassengerinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//逻辑代码写在这里

@Service
public class PassengerinfoService implements IPassengerinfoService {

    @Autowired
    private PassengerinfoMapper passengerinfoMapper;

    @Override
    public List<Passengerinfo>findAll(){
        List<Passengerinfo>list = passengerinfoMapper.findAll();
        return list;
    }

    @Override
    public List<Passengerinfo>findById(Integer id){
        List<Passengerinfo>list = passengerinfoMapper.findById(id);
        return list;
    }

    @Override
    public List<Passengerinfo>findMyself(Passengerinfo passengerinfo){
        List<Passengerinfo>list = passengerinfoMapper.findMyself(passengerinfo);
        return list;
    }

    @Override
    public void insert(Passengerinfo passengerinfo){
        passengerinfoMapper.insert(passengerinfo);
    }

    @Override
    public void update(Passengerinfo passengerinfo){
        passengerinfoMapper.update(passengerinfo);
    }

    @Override
    public void deleteById(Integer id){ passengerinfoMapper.deleteById(id); }

    @Override
    public void deleteBatch(Integer[] id){ passengerinfoMapper.deleteBatch(id); }

}
