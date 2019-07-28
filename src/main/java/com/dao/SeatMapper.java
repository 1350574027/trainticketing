package com.dao;

import com.entity.*;

import java.util.List;

public interface SeatMapper {

    Trainseat findtrainseat(Integer trainstate);

    Traininfo findTraininfo(String trainid);

    void updateSeatid(ShowResult showResult);
}
