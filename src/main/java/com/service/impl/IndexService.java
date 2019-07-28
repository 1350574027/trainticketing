package com.service.impl;

import com.dao.IndexMapper;
import com.entity.SelectTrain;
import com.entity.Station;
import com.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService implements IIndexService {

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public List<Station>findStation(SelectTrain selectTrain){
        List<Station>list = indexMapper.findStation(selectTrain);
        return list;
    }

    @Override
    public List<Station> findTrainstate (SelectTrain selectTrain){
        List<Station>trainstate = indexMapper.findTrainstate(selectTrain);
        return trainstate;
    }

    @Override
    public List<Station> findArrivaltime (SelectTrain selectTrain){
        List<Station>trainstate = indexMapper.findArrivaltime(selectTrain);
        return trainstate;
    }

    @Override
    public List<Station>findTrainid(Station station){
        List<Station>trainid = indexMapper.findTrainid(station);
        return trainid;
    }

    @Override
    public List<Station>findid(Station station) {
        List<Station> id = indexMapper.findid(station);
        return id;
    }

    @Override
    public List<Station>findBystate(Integer trainstate){
        List<Station> list = indexMapper.findBystate(trainstate);
        return list;
    }

    @Override
    public List<String> findStateid(Integer trainstate){
        List<String> trainid = indexMapper.findStateid(trainstate);
        return trainid;
    }


    @Override
    public List<Station>findResult(SelectTrain selectTrain){
        List<Station> list = indexMapper.findResult(selectTrain);
        return list;
    }

    @Override
    public List<Station>findResultchufa(SelectTrain selectTrain){
        List<Station> list = indexMapper.findResultchufa(selectTrain);
        return list;
    }

    @Override
    public List<Station>findResultdaoda(SelectTrain selectTrain){
        List<Station> list = indexMapper.findResultdaoda(selectTrain);
        return list;
    }
}
