package com.own.service.exception;

import java.util.List;
import java.util.Map;

import com.own.service.exception.BaseException.ExceptionType;

public class ServiceException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(Throwable e) {
		super(e);
	}

	public ServiceException(ExceptionType type, Integer errorCode,
			String message, Throwable e) {
		super(type, errorCode, message, e);
	}

	public ServiceException(ExceptionType type, Integer errorCode,
			String[] placeHolder, Throwable e) {
		super(type, errorCode, placeHolder, e);
	}

	public ServiceException(Map<ExceptionType, Map<Integer, List<Object>>> errorMap,
			Throwable e) {
		super(errorMap, e);
	}

	public ServiceException(ExceptionType type,Integer errorCode,Throwable e)
	{
		super(type,errorCode,e);
	}

	public ServiceException(ExceptionType view, Map<Integer, List<Object>> response,
			Throwable throwable) {
		super(view,response,throwable);
	}

	@Override
	public ServiceException addErrorCode(ExceptionType type, Integer errorCode,
			Object element) {
		appendErrorCode(type, errorCode, element);
		return this;
	}
}
