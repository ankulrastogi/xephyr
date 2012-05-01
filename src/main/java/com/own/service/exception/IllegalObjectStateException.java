package com.own.service.exception;

import java.util.Map;

public class IllegalObjectStateException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public IllegalObjectStateException() {
		super();
	}
	
	public IllegalObjectStateException(String errorCode,String message)
	{
		super(errorCode,message);
	}
	
	public IllegalObjectStateException(Map<String, String> errorMap)
	{
		super(errorMap);
	}

	@Override
	public IllegalObjectStateException addErrorCode(String error, String message) {
		
		this.errorCodes.put(error, message);
		return this;
	}

}
