package com.hotelSweetHome.hotelSweetHome.models.dao;

import com.hotelSweetHome.hotelSweetHome.models.entity.EstadoHabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoHabitacionDAO extends JpaRepository<EstadoHabitacionEntity, Long> {}
