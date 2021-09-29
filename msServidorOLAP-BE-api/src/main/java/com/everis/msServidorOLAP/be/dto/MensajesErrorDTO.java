package com.everis.msServidorOLAP.be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensajesErrorDTO {
    private String codigoError;
    private String mensajeError;
}
