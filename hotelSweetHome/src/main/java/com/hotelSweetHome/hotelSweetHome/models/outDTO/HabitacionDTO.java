package com.hotelSweetHome.hotelSweetHome.models.outDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionDTO {

    private Long idHabitacion;
    private String numeroHabitacion;
    private EstadoHabitacionDTO estadoHabitacion;
}
