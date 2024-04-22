package com.hotelSweetHome.hotelSweetHome.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class HuespedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHuesped")
    private Long idHuesped;

    @NotNull(message = "El campo nombreHuesped no puede ser nulo.")
    @Column(name = "nombreHuesped", nullable = false)
    private String nombreHuesped;

    @NotNull(message = "El campo documentoHuesped no puede ser nulo.")
    @Column(name = "documentoHuesped", nullable = false)
    private String documentoHuesped;

    @NotNull(message = "El campo telefonoHuesped no puede ser nulo.")
    @Column(name = "telefonoHuesped", nullable = false)
    private String telefonoHuesped;

    @NotNull(message = "El campo emailHuesped no puede ser nulo.")
    @Column(name = "emailHuesped", nullable = false)
    private String emailHuesped;

    @NotNull(message = "El campo hospedado no puede ser nulo.")
    @Builder.Default
    @Column(name = "hospedado", nullable = false)
    private boolean hospedado = false;
}
