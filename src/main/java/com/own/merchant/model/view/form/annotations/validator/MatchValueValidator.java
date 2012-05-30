package com.own.merchant.model.view.form.annotations.validator;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.own.merchant.model.view.form.annotations.MatchValues;

public class MatchValueValidator implements
		ConstraintValidator<MatchValues, Object> {

	private String field;
	private String verifyField;
	
	@Override
	public void initialize(MatchValues match) {
		this.field = match.field();
		this.verifyField = match.verifyField();
	
	}

	@Override
	public boolean isValid(Object element, ConstraintValidatorContext context) {
		
		boolean valid = false;
		
		try {
			Object fieldValue = BeanUtils.getProperty(element, field);
			Object matchValue = BeanUtils.getProperty(element, verifyField);
			
			if(!fieldValue.equals(matchValue))
					{
						context.disableDefaultConstraintViolation();
						context.buildConstraintViolationWithTemplate("{email.verify.mismatch}").addNode(verifyField).addConstraintViolation();
					}
			else
			{
				valid=true;
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return valid;
	}
}
