package com.everis.msdemo.be.dto;

import lombok.Data;

@Data
public class ResponseDTO {
	private Object response;
	private ErrorDTO error;

	public ResponseDTO() {
		error = new ErrorDTO();
	}
}