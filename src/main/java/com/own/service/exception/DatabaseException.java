package com.own.service.exception;

import java.util.List;
import java.util.Map;

public class DatabaseException extends BaseException {

private static final long serialVersionUID = 1L;
	

	public DatabaseException(Throwable e) {
		super(e);
	}
	public DatabaseException(ExceptionType type,Integer errorCode,String message,Throwable e)
	{
		super(type,errorCode,message,e);
	}
	
	public DatabaseException(ExceptionType type,Integer errorCode,String[] placeHolder,Throwable e)
	{
		super(type,errorCode,placeHolder,e);
	}
	
	public DatabaseException(Map<ExceptionType,Map<Integer, List<Object>>> errorMap,Throwable e)
	{
		super(errorMap,e);
	}
	public DatabaseException(ExceptionType log,
			Integer databaseError, Throwable e) {
		super(log,databaseError,e);
	}
	@Override
	public DatabaseException addErrorCode(ExceptionType type, Integer errorCode,
			Object element) {
		appendErrorCode(type, errorCode, element);
		return this;
	}

}
