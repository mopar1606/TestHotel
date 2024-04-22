package com.hotelSweetHome.hotelSweetHome.services.impl;

import com.hotelSweetHome.hotelSweetHome.models.dao.IHuespedDAO;
import com.hotelSweetHome.hotelSweetHome.models.entity.HuespedEntity;
import com.hotelSweetHome.hotelSweetHome.services.IHuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class HuespedServiceImpl implements IHuespedService {

    @Autowired
    private IHuespedDAO huespedDAO;

    @Override
    @Transactional(readOnly = true)
    public List<HuespedEntity> findAll() {
        return huespedDAO.findAll();
    }

    @Override
    public HuespedEntity findByDato(String dato) {

        HuespedEntity respuesta;

        respuesta = huespedDAO.findByDocumentoHuesped(dato).orElse(null);

        if(Objects.isNull(respuesta)){
            respuesta = huespedDAO.findByTelefonoHuesped(dato).orElse(null);
        }

        if(Objects.isNull(respuesta)){
            respuesta = huespedDAO.findByEmailHuesped(dato).orElse(null);
        }

        return respuesta;
    }

    @Override
    public HuespedEntity save(HuespedEntity objeto) {
        return huespedDAO.save(objeto);
    }
}
