package com.own.service.exception;

import java.util.List;


/**
 * Exception for the case if a duplicate value is observed to be existing.
 * @author ankul
 *
 */
public class DuplicateValueException extends BaseException {

	private Object dupValue;
	
	
	
	public DuplicateValueException(Object dupValue) {
		this.dupValue = dupValue;
	}
	
	public Object getDuplicateValue()
	{
		return dupValue;
	}

	
}
