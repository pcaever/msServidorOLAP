package com.everis.msdemo.be.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.everis.msdemo.be.constant.ConstantMsg;
import com.everis.msdemo.be.dto.MensajesErrorDTO;
import com.everis.msdemo.be.dto.ResponseDTO;

@Service
public class ControlErrorService {
	@Autowired
	private AdicionalService adicionalService;
	
	public ResponseDTO getErrorValidation(BindingResult ex) {
		ResponseDTO responseDTO = new ResponseDTO();

		Optional<ObjectError> errorLongitud = ex.getAllErrors().stream()
			.filter(filterLength -> 
				filterLength.getCode().equals("Length")
				|| filterLength.getCode().equals("Digits") 
				|| filterLength.getCode().equals("DecimalMax")).findFirst();

		Optional<ObjectError> invalidValue = ex.getAllErrors().stream()
			.filter(filterLength -> 
				filterLength.getCode().equals("Pattern")
				|| filterLength.getCode().equals("Min")
				|| filterLength.getCode().equals("Max")
				|| filterLength.getCode().equals("typeMismatch")).findFirst();

		Optional<ObjectError> errorCustom = ex.getAllErrors().stream()
			.filter(filterLength -> 
				filterLength.getCode().equals("EstadosDTOValidator")
				|| filterLength.getCode().equals("GenericDTOValidator")
				|| filterLength.getCode().equals("ParametrosDTOValidator")).findFirst();

		if (errorLongitud.isPresent()) {
			MensajesErrorDTO mensajeError = adicionalService.getMensajeError(ConstantMsg.CODE_400L, Arrays.asList(((FieldError) errorLongitud.get()).getField()));
			responseDTO.getError().setCodError(mensajeError.getCodigoError());
			responseDTO.getError().setMessError(mensajeError.getMensajeError());
		} else if (invalidValue.isPresent()) {
			MensajesErrorDTO mensajeError = adicionalService.getMensajeError(ConstantMsg.CODE_400F, Arrays.asList((((FieldError) invalidValue.get()).getField())));
			responseDTO.getError().setCodError(mensajeError.getCodigoError());
			responseDTO.getError().setMessError(mensajeError.getMensajeError());
		} else if (errorCustom.isPresent()) {
			Optional<ObjectError> messageCustom = ex.getAllErrors().stream()
				.filter(filterLength -> !StringUtils.isEmpty(filterLength.getDefaultMessage())
					&& filterLength.getDefaultMessage().contains("|")).findFirst();
			
			responseDTO = getErrorGenericDTO(messageCustom.isPresent() ? messageCustom.get() : errorCustom.get());
		}
		else {
			Optional<ObjectError> errorObligatoriedad = ex.getAllErrors().stream().findFirst();
			
			MensajesErrorDTO mensajeError = adicionalService.getMensajeError(ConstantMsg.CODE_400O, 
					Arrays.asList(errorObligatoriedad.isPresent() ? ((FieldError) errorObligatoriedad.get()).getField() : "missingField"));
			responseDTO.getError().setCodError(mensajeError.getCodigoError());
			responseDTO.getError().setMessError(mensajeError.getMensajeError());
		}

		return responseDTO;
	}

	public ResponseDTO getErrorGenericDTO(ObjectError objectError) {
		ResponseDTO responseDTO = new ResponseDTO();

		FieldError fieldError = (FieldError) objectError;
		String errorMessage = fieldError.getDefaultMessage();

		if (errorMessage != null && !errorMessage.contains("|")) {
			MensajesErrorDTO mensajeError = adicionalService.getMensajeError(ConstantMsg.CODE_400O, Arrays.asList(fieldError.getField()));
			responseDTO.getError().setCodError(mensajeError.getCodigoError());
			responseDTO.getError().setMessError(mensajeError.getMensajeError());
		} else {
			String messageError = fieldError.getDefaultMessage() == null ? "|" : fieldError.getDefaultMessage();
			String[] splitError = messageError == null ? "|".split("\\|") : messageError.split("\\|");

			if (splitError[0].equals("Length")) {
				MensajesErrorDTO mensajeError = adicionalService.getMensajeError(ConstantMsg.CODE_400L, 
						Arrays.asList(String.format("%s%s", fieldError.getField(), splitError[1])));
				responseDTO.getError().setCodError(mensajeError.getCodigoError());
				responseDTO.getError().setMessError(mensajeError.getMensajeError());
			} else {
				MensajesErrorDTO mensajeError = adicionalService.getMensajeError(ConstantMsg.CODE_400O, 
						Arrays.asList(String.format("%s%s", fieldError.getField(), splitError[1])));
				responseDTO.getError().setCodError(mensajeError.getCodigoError());
				responseDTO.getError().setMessError(mensajeError.getMensajeError());
			}
		}

		return responseDTO;
	}
}
