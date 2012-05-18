package com.own.service.exception;

import java.util.Map;

public class ServiceException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ServiceException(Throwable e) {
		super(e);
	}
	
	public ServiceException(Map<String, String> errorMessage,Throwable e)
	{
		super(errorMessage,e);
	}
	
	
	public ServiceException(String errorCode,String message,Throwable e)
	{
		super(errorCode,message,e);
	}
	
	@Override
	public ServiceException addErrorCode(String error, String message) {
		
		this.errorCodes.put(error, message);
		return this;
	}
}
