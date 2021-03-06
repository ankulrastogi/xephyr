package com.own.service.exception;

import java.util.List;
import java.util.Map;

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

	public MerchantException(Map<ExceptionType, Map<Integer, List<Object>>> errorMap,
			Throwable e) {
		super(errorMap, e);
	}

	public MerchantException(ExceptionType view, Map<Integer, List<Object>> response,
			Throwable throwable) {
		super(view,response,throwable);
	}
	@Override
	public MerchantException addErrorCode(ExceptionType type, Integer errorCode,
			Object element) {
		appendErrorCode(type, errorCode, element);
		return this;
	}

}
