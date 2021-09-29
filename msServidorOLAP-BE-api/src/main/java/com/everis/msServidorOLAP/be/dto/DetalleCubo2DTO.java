package com.everis.msServidorOLAP.be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCubo2DTO {
    public String cubo;
    //private List<BeDalDetalleCuboDimensionDTO> dimensiones;
    public BeDalDetalleCuboDimension2DTO[] dimensiones;

}
