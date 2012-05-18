package com.own.service.exception;

import java.util.Map;



/**
 * Exception for the case if a duplicate value is observed to be existing.
 * @author ankul
 *
 */
public class DuplicateValueException extends BaseException {

	private Object dupValue;
	
	public DuplicateValueException(Throwable e) {
		super(e);
	}
	
	public DuplicateValueException(String errorCode,String message,Throwable e)
	{
		super(errorCode,message,e);
	}
	
	public DuplicateValueException(Map<String, String> errorMap,Throwable e)
	{
		super(errorMap,e);
	}
	
	@Override
	public DuplicateValueException addErrorCode(String error, String message) {
		
		this.errorCodes.put(error, message);
		return this;
	}

	
}
