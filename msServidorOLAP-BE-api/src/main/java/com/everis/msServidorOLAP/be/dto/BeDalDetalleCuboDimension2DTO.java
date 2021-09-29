package com.everis.msServidorOLAP.be.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BeDalDetalleCuboDimension2DTO {
    private String nombre;
    private DetalleCuboDimensionValor2DTO[] valores;


}
