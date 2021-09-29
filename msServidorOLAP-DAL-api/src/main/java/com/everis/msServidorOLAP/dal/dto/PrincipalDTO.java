package com.everis.msServidorOLAP.dal.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrincipalDTO {
	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String observaciones;
	private String ejemplo;
	private Integer paisId;
	private Integer usuarioCrea;
	private Integer usuarioActualiza;
	private List<AdjuntoDTO> adjuntos;
}
