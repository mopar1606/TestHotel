package com.hotelSweetHome.hotelSweetHome.services.impl;

import com.hotelSweetHome.hotelSweetHome.models.dao.IHabitacionDAO;
import com.hotelSweetHome.hotelSweetHome.models.entity.HabitacionEntity;
import com.hotelSweetHome.hotelSweetHome.services.IHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

    @Autowired
    private IHabitacionDAO habitacionDAO;

    @Override
    @Transactional(readOnly = true)
    public List<HabitacionEntity> findAll() {
        return habitacionDAO.findAll();
    }

    @Override
    public HabitacionEntity findById(Long idEstado) {
        return habitacionDAO.findById(idEstado).orElse(null);
    }

    @Override
    public HabitacionEntity findByNumeroHabitacion(String numeroHabitacion) {
        return habitacionDAO.findByNumeroHabitacion(numeroHabitacion);
    }

    @Override
    public HabitacionEntity save(HabitacionEntity objeto) {
        return habitacionDAO.save(objeto);
    }
}
