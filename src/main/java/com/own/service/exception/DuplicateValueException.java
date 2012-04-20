package com.own.service.exception;

import java.util.List;


/**
 * Exception for the case if a duplicate value is observed to be existing.
 * @author ankul
 *
 */
public class DuplicateValueException extends Exception {

	private Object dupValue;
	
	private List<String> errorCode;
	
	public DuplicateValueException(Object dupValue) {
		this.dupValue = dupValue;
	}
	
	public Object getDuplicateValue()
	{
		return dupValue;
	}

	public List<String> getErrorCode() {
		
		return errorCode;
	}
	
	public void addErrorCode(String errorCode)
	{
		this.errorCode.add(errorCode);
	}
	
}
