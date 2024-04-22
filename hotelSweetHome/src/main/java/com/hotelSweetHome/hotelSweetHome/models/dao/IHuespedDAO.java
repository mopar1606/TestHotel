package com.hotelSweetHome.hotelSweetHome.models.dao;

import com.hotelSweetHome.hotelSweetHome.models.entity.HuespedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IHuespedDAO extends JpaRepository<HuespedEntity, Long> {

    @Query("SELECT h FROM HuespedEntity h WHERE h.documentoHuesped = :documentoHuesped")
    Optional<HuespedEntity> findByDocumentoHuesped(String documentoHuesped);

    @Query("SELECT h FROM HuespedEntity h WHERE h.telefonoHuesped = :telefonoHuesped")
    Optional<HuespedEntity> findByTelefonoHuesped(String telefonoHuesped);

    @Query("SELECT h FROM HuespedEntity h WHERE h.emailHuesped = :emailHuesped")
    Optional<HuespedEntity> findByEmailHuesped(String emailHuesped);
}
