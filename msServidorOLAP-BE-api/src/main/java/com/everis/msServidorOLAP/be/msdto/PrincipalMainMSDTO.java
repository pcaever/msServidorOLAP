package com.everis.msdemo.be.msdto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalMainMSDTO {
	@Valid
	@NotNull
	private PrincipalMSDTO principal; 
	
	@Valid
	@Size(min = 1)
	private List<DocumentosMSDTO> documentosSoporte;
}
