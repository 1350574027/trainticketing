package com.dao;

import com.entity.SelectTrain;
import com.entity.Station;

import java.util.List;

public interface IndexMapper {
    List<Station>findStation(SelectTrain selectTrain);

    List<Station>findTrainstate(SelectTrain selectTrain);

    List<Station>findArrivaltime(SelectTrain selectTrain);

    List<Station>findTrainid(Station station);

    List<Station>findid(Station station);

    List<Station>findBystate(Integer trainstate);

    List<String> findStateid(Integer trainstate);

    List<Station>findResult(SelectTrain selectTrain);

    List<Station>findResultchufa(SelectTrain selectTrain);

    List<Station>findResultdaoda(SelectTrain selectTrain);
}
