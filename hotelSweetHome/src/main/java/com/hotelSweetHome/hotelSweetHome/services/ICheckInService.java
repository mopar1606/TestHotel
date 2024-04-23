package com.hotelSweetHome.hotelSweetHome.services;

import com.hotelSweetHome.hotelSweetHome.models.entity.CheckInEntity;

import java.util.List;
import java.util.Optional;

public interface ICheckInService {

    public List<CheckInEntity> findAll();

    public CheckInEntity save(CheckInEntity objeto);

    public List<CheckInEntity> findByFechaSalidaIsNull();

    public List<CheckInEntity> findByFechaSalidaIsNotNull();

    public Optional<CheckInEntity> findByHuespedDocumentoHuespedAndFechaSalidaIsNull(String documentoHuesped);

    public Optional<CheckInEntity> findByHuespedDocumentoHuespedAndFechaSalidaIsNotNull(String documentoHuesped);
}
