package com.dao;

import com.entity.Passengerinfo;

import java.util.List;

public interface PassengerinfoMapper {
    List<Passengerinfo>findAll();

    List<Passengerinfo>findById(Integer id);

    List<Passengerinfo>findMyself(Passengerinfo passengerinfo);

    void update(Passengerinfo passengerinfo);

    void insert(Passengerinfo passengerinfo);

    void deleteById(Integer id);

    void deleteBatch(Integer[] id);
}
