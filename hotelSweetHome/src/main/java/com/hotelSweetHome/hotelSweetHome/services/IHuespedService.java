package com.hotelSweetHome.hotelSweetHome.services;

import com.hotelSweetHome.hotelSweetHome.models.entity.HuespedEntity;

import java.util.List;

public interface IHuespedService {

    public List<HuespedEntity> findAll();

    public HuespedEntity findByDato(String dato);

    public HuespedEntity save(HuespedEntity objeto);
}
