package com.own.service.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

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


	public BaseException() {
		super();
	}

	public BaseException(String errorCode, String message) {
		super();
		addErrorCode(errorCode, message);
	}
	
	public BaseException(Map<String, String> errorMap)
	{
		this.errorCodes = errorMap;
	}

	public abstract BaseException addErrorCode(String error,String message); 
	
	public Map<String, String> getErrorMessages()
	{
		return this.errorCodes;
	}

	
}
