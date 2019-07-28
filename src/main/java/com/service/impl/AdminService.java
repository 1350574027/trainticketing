package com.service.impl;

import com.dao.AdminMapper;
import com.dao.PassengerinfoMapper;
import com.entity.Passengerinfo;
import com.entity.Station;
import com.entity.Traininfo;
import com.entity.Trainseat;
import com.service.IAdminService;
import com.service.IPassengerinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//逻辑代码写在这里

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Traininfo>findAll(){
        List<Traininfo>list = adminMapper.findAll();
        return list;
    }

    @Override
    public void insertTraininfo(Traininfo traininfo){
        adminMapper.insertTraininfo(traininfo);
    }

    @Override
    public Integer insertAndGetState(Trainseat trainseat){
        Integer trainstate = adminMapper.insertAndGetState(trainseat);
        return trainstate;
    }

    @Override
    public void addStation(Station station){
        adminMapper.addStation(station);
    }

    @Override
    public List<Station>stationlist(Integer index){
        List<Station>list =adminMapper.stationlist(index);
        return list;
    }

    @Override
    public Integer pagecount(){
        Integer page = adminMapper.pagecount();
        return page;
    }


}
