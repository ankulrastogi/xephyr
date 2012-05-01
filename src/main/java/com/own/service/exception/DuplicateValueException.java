package com.own.service.exception;

import java.util.Map;



/**
 * Exception for the case if a duplicate value is observed to be existing.
 * @author ankul
 *
 */
public class DuplicateValueException extends BaseException {

	private Object dupValue;
	
	public DuplicateValueException() {
		super();
	}
	
	public DuplicateValueException(String errorCode,String message)
	{
		super(errorCode,message);
	}
	
	public DuplicateValueException(Map<String, String> errorMap)
	{
		super(errorMap);
	}
	
	@Override
	public DuplicateValueException addErrorCode(String error, String message) {
		
		this.errorCodes.put(error, message);
		return this;
	}

	
}
