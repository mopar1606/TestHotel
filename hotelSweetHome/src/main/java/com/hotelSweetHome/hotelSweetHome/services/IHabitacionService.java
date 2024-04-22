package com.hotelSweetHome.hotelSweetHome.services;

import com.hotelSweetHome.hotelSweetHome.models.entity.HabitacionEntity;

import java.util.List;

public interface IHabitacionService {

    public List<HabitacionEntity> findAll();

    public HabitacionEntity findById(Long idEstado);

    public HabitacionEntity findByNumeroHabitacion(String numeroHabitacion);

    public HabitacionEntity save(HabitacionEntity objeto);
}
