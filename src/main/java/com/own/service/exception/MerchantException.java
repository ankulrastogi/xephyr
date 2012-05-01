package com.own.service.exception;

import java.util.Map;

/**
 * Exception that thrown in case of any merchant related issues
 * @author ankul
 *
 */
public class MerchantException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MerchantException() {
		super();
	}
	
	public MerchantException(String errorCode,String message)
	{
		super(errorCode,message);
	}
	
	public MerchantException(Map<String, String> errorMap)
	{
		super(errorMap);
	}
	
	@Override
	public MerchantException addErrorCode(String error, String message) {
		
		this.errorCodes.put(error, message);
		return this;
	}
}
