package com.own.service.exception;

import java.util.Map;

public class IllegalObjectStateException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalObjectStateException(Throwable e) {
		super(e);
	}

	public IllegalObjectStateException(ExceptionType type, Integer errorCode,
			String message, Throwable e) {
		super(type, errorCode, message, e);
	}

	public IllegalObjectStateException(ExceptionType type, Integer errorCode,
			String[] placeHolder, Throwable e) {
		super(type, errorCode, placeHolder, e);
	}

	public IllegalObjectStateException(
			Map<ExceptionType, Map<Integer, Object>> errorMap, Throwable e) {
		super(errorMap, e);
	}

	@Override
	public IllegalObjectStateException addErrorCode(ExceptionType type, Integer errorCode,
			Object element) {
		appendErrorCode(type, errorCode, element);
		return this;
	}

}
