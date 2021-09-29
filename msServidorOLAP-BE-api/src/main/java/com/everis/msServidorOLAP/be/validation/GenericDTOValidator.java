package com.everis.msdemo.be.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE, TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { GenericDTOConstraint.class })
public @interface GenericDTOValidator {
	String message() default "GenericDTO es obligatorio";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	int minCode() default 0;
	int maxCode() default 100;
	boolean allowNull() default false;
}