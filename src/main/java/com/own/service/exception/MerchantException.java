package com.own.service.exception;

import java.util.Map;

import com.own.service.exception.BaseException.ExceptionType;

/**
 * Exception that thrown in case of any merchant related issues
 * 
 * @author ankul
 * 
 */
public class MerchantException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MerchantException(Throwable e) {
		super(e);
	}

	public MerchantException(ExceptionType type, Integer errorCode,
			String message, Throwable e) {
		super(type, errorCode, message, e);
	}

	public MerchantException(ExceptionType type, Integer errorCode,
			String[] placeHolder, Throwable e) {
		super(type, errorCode, placeHolder, e);
	}

	public MerchantException(Map<ExceptionType, Map<Integer, Object>> errorMap,
			Throwable e) {
		super(errorMap, e);
	}

	@Override
	public MerchantException addErrorCode(ExceptionType type, Integer errorCode,
			Object element) {
		appendErrorCode(type, errorCode, element);
		return this;
	}

}
