package com.hotelSweetHome.hotelSweetHome.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "checkIn")
public class CheckInEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCheckIn")
    private Long idCheckIn;

    @NotNull(message = "El campo fechaEntrada no puede ser nulo.")
    @Column(name = "fechaEntrada", nullable = false)
    private LocalDateTime fechaEntrada;

    @Column(name = "fechaSalida", nullable = false)
    private LocalDateTime fechaSalida;

    @NotNull(message = "El campo adicionalVehiculo no puede ser nulo.")
    @Builder.Default
    @Column(name = "adicionalVehiculo", nullable = false)
    private boolean adicionalVehiculo = false;

    @NotNull(message = "El registro huesped no puede ser nulo.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHuesped")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private HuespedEntity huesped;

    @NotNull(message = "El registro habitacion no puede ser nulo.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHabitacion")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private HabitacionEntity habitacion;
}
