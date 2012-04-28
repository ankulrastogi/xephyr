package com.own.service.exception;

import java.util.Map;

/**
 * Exception to track if the basic merchant validation has field.
 * Checks if the required field have proper values
 * Not sure if it is required
 * @author Ankul.Rastogi
 *
 */
public class MerchantValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, String> errorMap = null;
	
	public MerchantValidationException(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}
	
	public Map<String, String> getErrorMap()
	{
		return errorMap;
	}
}
