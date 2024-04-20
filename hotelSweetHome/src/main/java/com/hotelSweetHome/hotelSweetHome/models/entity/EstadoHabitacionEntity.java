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
@Table(name = "estadoHabitacion")
public class EstadoHabitacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstado")
    private Long idEstado;

    @NotNull(message = "El campo numeroHabitacion no puede ser nulo.")
    @Column(name = "descripcionEstado", nullable = false)
    private String descripcionEstado;
}
