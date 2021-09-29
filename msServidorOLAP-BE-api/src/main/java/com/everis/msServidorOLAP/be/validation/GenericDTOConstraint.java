package com.everis.msdemo.be.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.everis.msdemo.be.dto.GenericDTO;

public class GenericDTOConstraint implements ConstraintValidator<GenericDTOValidator, GenericDTO> {
	public boolean isValid(GenericDTO value, ConstraintValidatorContext context) {
		if (allowNull && value == null) {
			return true;
		}
		
		if ((!allowNull && value == null) || (value.getId() == null && value.getCode() == null)) {
			return false;
		}

		if (value.getCode() != null && (value.getCode().length() < this.minCode || value.getCode().length() > this.maxCode)) {
			context.buildConstraintViolationWithTemplate("Length|.code").addConstraintViolation();
			return false;
		}

		return true;
	}

	@Override
	public void initialize(GenericDTOValidator constraintAnnotation) {
		this.minCode = constraintAnnotation.minCode();
		this.maxCode = constraintAnnotation.maxCode();
		this.allowNull = constraintAnnotation.allowNull();
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	int minCode;
	int maxCode;
	boolean allowNull;
}