package com.hotelSweetHome.hotelSweetHome.models.dao;

import com.hotelSweetHome.hotelSweetHome.models.entity.CheckInEntity;
import com.hotelSweetHome.hotelSweetHome.models.entity.HuespedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICheckInDAO extends JpaRepository<CheckInEntity, Long> {

    List<CheckInEntity> findByHuespedAndFechaSalidaIsNullOrFechaSalidaAfter(HuespedEntity huesped, LocalDateTime fechaActual);

    Optional<CheckInEntity> findByHuespedDocumentoHuespedAndFechaSalidaIsNull(String documentoHuesped);

    Optional<CheckInEntity> findByHuespedDocumentoHuespedAndFechaSalidaIsNotNull(String documentoHuesped);

    List<CheckInEntity> findByHuesped_DocumentoHuesped(String documentoHuesped);

    List<CheckInEntity> findByFechaSalidaIsNull();

    List<CheckInEntity> findByFechaSalidaIsNotNull();
}
