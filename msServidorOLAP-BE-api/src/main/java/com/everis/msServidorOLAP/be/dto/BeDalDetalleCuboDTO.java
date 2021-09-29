package com.everis.msdemo.be.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BeDalDetalleCuboDTO {

    private String cubo;

    private BeDalDetalleCuboDimensionDTO[] dimensiones;

}
