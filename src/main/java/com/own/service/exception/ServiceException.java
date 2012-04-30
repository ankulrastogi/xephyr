package com.own.service.exception;

import java.util.HashMap;
import java.util.Map;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, String> errorMessage;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(Map<String, String> errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	
	public Map<String, String> getErrorMessage()
	{
		return this.errorMessage;
	}
	
	public ServiceException(String errorCode,String message)
	{
		this.errorMessage = new HashMap<String, String>();
		errorMessage.put(errorCode, message);
	}
}
