package com.everis.msdemo.dal.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdjuntoDTO {
	private Integer id;
	private Integer adjuntoId;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Integer usuarioCrea;
	private Integer usuarioActualiza;
}
