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

	public MerchantException(Throwable e) {
		super(e);
	}
	
	public MerchantException(String errorCode,String message,Throwable e)
	{
		super(errorCode,message,e);
	}
	
	public MerchantException(Map<String, String> errorMap,Throwable e)
	{
		super(errorMap,e);
	}
	
	@Override
	public MerchantException addErrorCode(String error, String message) {
		
		this.errorCodes.put(error, message);
		return this;
	}
}
