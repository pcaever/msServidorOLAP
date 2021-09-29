package com.everis.msdemo.be.msdto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.everis.msdemo.be.dto.GenericDTO;
import com.everis.msdemo.be.validation.GenericDTOValidator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrincipalMSDTO {
	@NotBlank
	@Length(max = 30)
	@Pattern(regexp = "^[^<>?#$/()=\\';:\"]*")
	private String nombre;
	
	@NotBlank
	@Length(max = 50)
	@Pattern(regexp = "^[^<>?#$/()=\\';:\"]*")
	private String direccion;
	
	@Length(min = 1, max = 30)
	@Pattern(regexp = "^[^<>?#$/()=\\';:\"]*")
	private String telefono;
	
	@Length(min = 1, max = 200)
	@Pattern(regexp = "^[^<>?#$/()=\\';:\"]*")
	private String observaciones;

	@NotNull
	@Valid
	@GenericDTOValidator(minCode = 1, maxCode = 5)
	private GenericDTO pais;
}
