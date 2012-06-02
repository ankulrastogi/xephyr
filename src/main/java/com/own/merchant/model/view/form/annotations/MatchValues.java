package com.own.merchant.model.view.form.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import com.own.merchant.model.view.form.annotations.validator.MatchValueValidator;

@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={MatchValueValidator.class})
@ReportAsSingleViolation
public @interface MatchValues {

	Class<? extends Payload>[] payload() default {};
	
	String message() default "Fields Do not match";
	
	Class<?>[] groups() default {};
	
	String field () default "";
	
	String verifyField() default "";
	
	@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List
	{
		MatchValues[] value();
	}
}
