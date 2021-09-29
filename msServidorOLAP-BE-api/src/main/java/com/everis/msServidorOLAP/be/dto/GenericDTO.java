package com.everis.msdemo.be.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class GenericDTO {
	private Integer id;
	
	@Length(max = 100)
	@Pattern(regexp = "^[^<>?#$/()=\\';:\"]*")
    private String description;
    
	@Pattern(regexp = "^[^<>?#$/()=\\';:\"]*")
    private String code;
}
