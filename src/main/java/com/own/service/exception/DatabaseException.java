package com.own.service.exception;

import java.util.Map;

public class DatabaseException extends BaseException {

private static final long serialVersionUID = 1L;
	
	
	public DatabaseException(Throwable e) {
		super(e);
	}
	
	public DatabaseException(String errorCode,String message,Throwable e)
	{
		super(errorCode,message,e);
	}
	
	public DatabaseException(Map<String, String> errorMap,Throwable e)
	{
		super(errorMap,e);
	}

	@Override
	public DatabaseException addErrorCode(String error, String message) {
		
		this.errorCodes.put(error, message);
		return this;
	}
}
