package com.service;

import com.entity.ShowResult;
import com.entity.Traininfo;
import com.entity.Trainseat;

import java.util.List;

public interface ISeatService {

    Trainseat findtrainseat(Integer trainstate);

    Traininfo findTraininfo(String trainid);

    void updateSeatid(ShowResult showResult);

}
