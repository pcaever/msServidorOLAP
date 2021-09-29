package com.everis.msdemo.be.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetalleCuboDimensionCampoDTO {
    private String tipo;
    private boolean visible;
    private DetalleCuboDimensionCampoValoresDTO valores;
}
