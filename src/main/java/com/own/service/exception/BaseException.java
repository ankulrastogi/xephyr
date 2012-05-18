package com.own.service.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * Base exception for the class. Each exception condition will be marked by an
 * error code.
 * 
 * @author ankul
 * 
 */

public abstract class BaseException extends Exception {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	protected Map<String, String> errorCodes = new HashMap<String,String>();


	public BaseException(Throwable e) {
		super(e);
	}

	public BaseException(String errorCode, String message,Throwable e) {
		super(e);
		addErrorCode(errorCode, message);
	}
	
	public BaseException(Map<String, String> errorMap,Throwable e)
	{
		super(e);
		this.errorCodes = errorMap;
	}

	public abstract BaseException addErrorCode(String error,String message); 
	
	public Map<String, String> getErrorMessages()
	{
		return this.errorCodes;
	}

	
}
