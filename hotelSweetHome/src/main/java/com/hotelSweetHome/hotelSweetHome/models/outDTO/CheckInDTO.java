package com.hotelSweetHome.hotelSweetHome.models.outDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckInDTO {

    private Long idCheckIn;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private boolean adicionalVehiculo;
    private HuespedDTO huesped;
    private HabitacionDTO habitacion;
}
