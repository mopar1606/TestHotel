package com.hotelSweetHome.hotelSweetHome.services;

import com.hotelSweetHome.hotelSweetHome.models.entity.EstadoHabitacionEntity;

import java.util.List;

public interface IEstadoHabitacionService {

    public List<EstadoHabitacionEntity> findAll();

    public EstadoHabitacionEntity findById(Long idEstado);

    public EstadoHabitacionEntity save(EstadoHabitacionEntity objeto);
}
