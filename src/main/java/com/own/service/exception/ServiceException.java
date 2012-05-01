package com.own.service.exception;

import java.util.HashMap;
import java.util.Map;

public class ServiceException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(Map<String, String> errorMessage)
	{
		super(errorMessage);
	}
	
	
	public ServiceException(String errorCode,String message)
	{
		super(errorCode,message);
	}
	
	@Override
	public ServiceException addErrorCode(String error, String message) {
		
		this.errorCodes.put(error, message);
		return this;
	}
}
