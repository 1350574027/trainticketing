package com.service.impl;

import com.dao.SeatMapper;
import com.entity.ShowResult;
import com.entity.Traininfo;
import com.entity.Trainseat;
import com.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements ISeatService {
    @Autowired
    private SeatMapper seatMapper;

    @Override
    public Trainseat findtrainseat(Integer trainstate){
        Trainseat list = seatMapper.findtrainseat(trainstate);
        return list;
    }

    @Override
    public Traininfo findTraininfo(String trainid){
        Traininfo traininfo = seatMapper.findTraininfo(trainid);
        return traininfo;
    }

    @Override
    public void updateSeatid(ShowResult showResult){
        seatMapper.updateSeatid(showResult);
    }

}
