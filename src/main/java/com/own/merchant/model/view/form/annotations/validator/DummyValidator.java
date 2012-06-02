package com.own.merchant.model.view.form.annotations.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.own.merchant.model.view.form.annotations.ValidEmail;

public class DummyValidator implements ConstraintValidator<ValidEmail, Object>{

	@Override
	public void initialize(ValidEmail paramA) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object paramT,
			ConstraintValidatorContext paramConstraintValidatorContext) {
		// TODO Auto-generated method stub
		return true;
	}

}
