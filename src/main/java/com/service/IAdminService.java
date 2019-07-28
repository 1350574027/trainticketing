package com.service;

import com.entity.Passengerinfo;
import com.entity.Station;
import com.entity.Traininfo;
import com.entity.Trainseat;

import java.util.List;

public interface IAdminService {

    List<Traininfo>findAll();

    void insertTraininfo(Traininfo traininfo);

    Integer insertAndGetState(Trainseat trainseat);

    void addStation(Station station);

    List<Station>stationlist(Integer index);

    Integer pagecount();

}
