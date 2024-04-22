package com.hotelSweetHome.hotelSweetHome.models.outDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HuespedDTO {

    private Long idHuesped;
    private String nombreHuesped;
    private String documentoHuesped;
    private String telefonoHuesped;
    private String emailHuesped;
    private boolean hospedado;
}
