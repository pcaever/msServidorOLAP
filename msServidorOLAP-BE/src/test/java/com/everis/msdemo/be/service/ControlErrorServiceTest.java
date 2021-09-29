package com.everis.msServidorOLAP.be.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.HandlerMethod;

import com.everis.msServidorOLAP.be.dto.ResponseDTO;

/**
 * The Class ControlErrorServiceTest
 */
class ControlErrorServiceTest {

	/*@InjectMocks
	private ControlErrorService controlErrorService;

	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testgetErrorValidationDefault() {
		BindingResult bindingResult = mock(BindingResult.class);
		FieldError fieldError = mock(FieldError.class);
		MethodArgumentNotValidException methodArgumentNotValidException = mock(MethodArgumentNotValidException.class);

		when(fieldError.getField()).thenReturn("name");
		when(fieldError.getDefaultMessage()).thenReturn("default message");
		when(fieldError.getCodes()).thenReturn(new String[] { "message" });
		when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(fieldError));
		when(methodArgumentNotValidException.getBindingResult()).thenReturn(bindingResult);

		ResponseDTO restErrorResponse = controlErrorService.getErrorValidation(methodArgumentNotValidException.getBindingResult());
		assertNotNull(restErrorResponse);
	}

	@Test
	void testgetErrorValidationLength() throws NoSuchMethodException, SecurityException {
		Method methodGetErrorValidation = ControlErrorService.class.getMethod("getErrorValidation",
				BindingResult.class);
		HandlerMethod handlerMethod = new HandlerMethod(new ControlErrorService(), methodGetErrorValidation);
		MethodParameter methodParameter = handlerMethod.getReturnType();

		FieldError fieldLength = new FieldError("Length", "Length", null, false, new String[] { "Length" }, null,
				"Length");
		BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "Length");
		bindingResult.addError(fieldLength);

		MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(
				methodParameter, bindingResult);

		ResponseDTO restErrorResponse = controlErrorService.getErrorValidation(methodArgumentNotValidException.getBindingResult());
		assertNotNull(restErrorResponse);
	}

	@Test
	void testgetErrorValidationNotNull() throws NoSuchMethodException, SecurityException {
		Method methodGetErrorValidation = ControlErrorService.class.getMethod("getErrorValidation",
				BindingResult.class);
		HandlerMethod handlerMethod = new HandlerMethod(new ControlErrorService(), methodGetErrorValidation);
		MethodParameter methodParameter = handlerMethod.getReturnType();

		FieldError fieldLength = new FieldError("Pattern", "Pattern", null, false, new String[] { "Pattern" }, null,
				"Pattern");
		BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "Pattern");
		bindingResult.addError(fieldLength);

		MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(
				methodParameter, bindingResult);

		ResponseDTO restErrorResponse = controlErrorService.getErrorValidation(methodArgumentNotValidException.getBindingResult());
		assertNotNull(restErrorResponse);
	}

	@Test
	void testgetErrorValidationPattern() throws NoSuchMethodException, SecurityException {
		Method methodGetErrorValidation = ControlErrorService.class.getMethod("getErrorValidation",
				BindingResult.class);
		HandlerMethod handlerMethod = new HandlerMethod(new ControlErrorService(), methodGetErrorValidation);
		MethodParameter methodParameter = handlerMethod.getReturnType();

		FieldError fieldLength = new FieldError("NotNull", "NotNull", null, false, new String[] { "NotNull" }, null,
				"NotNull");
		BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "NotNull");
		bindingResult.addError(fieldLength);

		MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(
				methodParameter, bindingResult);

		ResponseDTO restErrorResponse = controlErrorService.getErrorValidation(methodArgumentNotValidException.getBindingResult());
		assertNotNull(restErrorResponse);
	}

	@Test
	void testgetErrorGenericDTO() throws NoSuchMethodException, SecurityException {
		Method methodGetErrorValidation = ControlErrorService.class.getMethod("getErrorValidation",
				BindingResult.class);
		HandlerMethod handlerMethod = new HandlerMethod(new ControlErrorService(), methodGetErrorValidation);
		MethodParameter methodParameter = handlerMethod.getReturnType();

		FieldError fieldLength = new FieldError("GenericDTOValidator", "GenericDTOValidator", null, false, new String[] { "GenericDTOValidator" }, null,
				"NotNull");
		BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "NotNull");
		bindingResult.addError(fieldLength);

		MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(
				methodParameter, bindingResult);

		ResponseDTO restErrorResponse = controlErrorService.getErrorValidation(methodArgumentNotValidException.getBindingResult());
		assertNotNull(restErrorResponse);
	}

	@Test
	void testgetErrorGenericDTOElse() throws NoSuchMethodException, SecurityException {
		Method methodGetErrorValidation = ControlErrorService.class.getMethod("getErrorValidation",
				BindingResult.class);
		HandlerMethod handlerMethod = new HandlerMethod(new ControlErrorService(), methodGetErrorValidation);
		MethodParameter methodParameter = handlerMethod.getReturnType();

		FieldError fieldLength = new FieldError("GenericDTOValidator", "GenericDTOValidator", null, false, new String[] { "GenericDTOValidator" }, null,
				"GenericDTOValidator|GenericDTOValidator");
		BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "GenericDTOValidator");
		bindingResult.addError(fieldLength);

		MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(
				methodParameter, bindingResult);

		ResponseDTO restErrorResponse = controlErrorService.getErrorValidation(methodArgumentNotValidException.getBindingResult());
		assertNotNull(restErrorResponse);
	}

	@Test
	void testgetErrorGenericDTOElseLength() throws NoSuchMethodException, SecurityException {
		Method methodGetErrorValidation = ControlErrorService.class.getMethod("getErrorValidation",
				BindingResult.class);
		HandlerMethod handlerMethod = new HandlerMethod(new ControlErrorService(), methodGetErrorValidation);
		MethodParameter methodParameter = handlerMethod.getReturnType();

		FieldError fieldLength = new FieldError("GenericDTOValidator", "GenericDTOValidator", null, false, new String[] { "GenericDTOValidator" }, null,
				"Length|GenericDTOValidator");
		BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "GenericDTOValidator");
		bindingResult.addError(fieldLength);

		MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(
				methodParameter, bindingResult);

		ResponseDTO restErrorResponse = controlErrorService.getErrorValidation(methodArgumentNotValidException.getBindingResult());
		assertNotNull(restErrorResponse);
	}*/

}