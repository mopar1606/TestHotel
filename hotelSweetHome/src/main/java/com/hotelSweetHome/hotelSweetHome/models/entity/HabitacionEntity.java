package com.hotelSweetHome.hotelSweetHome.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "huesped")
public class HabitacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHabitacion")
    private Long idHabitacion;

    @NotNull(message = "El campo numeroHabitacion no puede ser nulo.")
    @Column(name = "numeroHabitacion", nullable = false)
    private String numeroHabitacion;

    @NotNull(message = "El campo estadoHabitacion no puede ser nulo.")
    @Column(name = "estadoHabitacion", nullable = false)
    private String estadoHabitacion;
}
