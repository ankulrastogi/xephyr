package com.own.service.exception;

import java.util.Map;



/**
 * Exception for the case if a duplicate value is observed to be existing.
 * @author ankul
 *
 */
public class DuplicateValueException extends BaseException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateValueException(Throwable e) {
		super(e);
	}
	public DuplicateValueException(ExceptionType type,Integer errorCode,String message,Throwable e)
	{
		super(type,errorCode,message,e);
	}
	
	public DuplicateValueException(ExceptionType type,Integer errorCode,String[] message,Throwable e)
	{
		super(type,errorCode,message,e);
	}
	
	public DuplicateValueException(Map<ExceptionType, Map<Integer, Object>> errorMap,Throwable e)
	{
		super(errorMap,e);
	}
	@Override
	public DuplicateValueException addErrorCode(ExceptionType type, Integer errorCode,
			Object element) {
		appendErrorCode(type, errorCode, element);
		return this;
	}
	
}
