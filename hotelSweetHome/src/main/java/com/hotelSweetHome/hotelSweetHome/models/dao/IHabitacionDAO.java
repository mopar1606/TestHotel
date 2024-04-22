package com.hotelSweetHome.hotelSweetHome.models.dao;

import com.hotelSweetHome.hotelSweetHome.models.entity.HabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabitacionDAO extends JpaRepository<HabitacionEntity, Long> {

    @Query("SELECT h FROM HabitacionEntity h WHERE h.numeroHabitacion = :numeroHabitacion")
    HabitacionEntity findByNumeroHabitacion(String numeroHabitacion);
}
