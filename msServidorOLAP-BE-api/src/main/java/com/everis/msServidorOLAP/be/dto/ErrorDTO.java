package com.everis.msdemo.be.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDTO {
	private String codError;
	private String messError;
	private String uuidError;
}
