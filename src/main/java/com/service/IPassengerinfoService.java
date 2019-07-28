package com.service;

import com.entity.Passengerinfo;

import java.util.List;

public interface IPassengerinfoService {

    List<Passengerinfo>findAll();

    List<Passengerinfo>findById(Integer id);

    List<Passengerinfo>findMyself(Passengerinfo passengerinfo);

    void insert(Passengerinfo passengerinfo);

    void update(Passengerinfo passengerinfo);

    void deleteById(Integer id);

    void deleteBatch(Integer[] id);

}
