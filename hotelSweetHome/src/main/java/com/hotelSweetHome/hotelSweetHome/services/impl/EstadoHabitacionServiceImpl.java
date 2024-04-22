package com.hotelSweetHome.hotelSweetHome.services.impl;

import com.hotelSweetHome.hotelSweetHome.models.dao.IEstadoHabitacionDAO;
import com.hotelSweetHome.hotelSweetHome.models.entity.EstadoHabitacionEntity;
import com.hotelSweetHome.hotelSweetHome.services.IEstadoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoHabitacionServiceImpl implements IEstadoHabitacionService {

    @Autowired
    private IEstadoHabitacionDAO estadoHabitacionDAO;

    @Override
    @Transactional(readOnly = true)
    public List<EstadoHabitacionEntity> findAll() {
        return estadoHabitacionDAO.findAll();
    }

    @Override
    public EstadoHabitacionEntity findById(Long idEstado) {
        return estadoHabitacionDAO.findById(idEstado).orElse(null);
    }

    @Override
    public EstadoHabitacionEntity save(EstadoHabitacionEntity objeto) {
        return estadoHabitacionDAO.save(objeto);
    }
}
