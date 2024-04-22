package com.hotelSweetHome.hotelSweetHome.models.outDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoHabitacionDTO {

    private Long idEstado;
    private String descripcionEstado;
}
