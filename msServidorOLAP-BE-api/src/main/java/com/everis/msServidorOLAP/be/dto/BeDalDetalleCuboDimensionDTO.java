package com.everis.msdemo.be.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BeDalDetalleCuboDimensionDTO {
    private String nombre;
    private DetalleCuboDimensionCampoValoresDTO[]valores;

}
