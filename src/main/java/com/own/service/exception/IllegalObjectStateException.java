package com.own.service.exception;

import java.util.Map;

public class IllegalObjectStateException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public IllegalObjectStateException(Throwable e) {
		super(e);
	}
	
	public IllegalObjectStateException(String errorCode,String message,Throwable e)
	{
		super(errorCode,message,e);
	}
	
	public IllegalObjectStateException(Map<String, String> errorMap,Throwable e)
	{
		super(errorMap,e);
	}

	@Override
	public IllegalObjectStateException addErrorCode(String error, String message) {
		
		this.errorCodes.put(error, message);
		return this;
	}

}
