package com.everis.msdemo.be.msdto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentosMSDTO {
	@NotBlank
	private String nombreDocumento;

	@NotBlank
	private String documentoBase64;
}
