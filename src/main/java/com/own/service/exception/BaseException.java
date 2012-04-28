package com.own.service.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Base exception for the class. Each exception condition will be marked by an
 * error code.
 * 
 * @author ankul
 * 
 */
public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, String> errorCodes;

	private Map<String, String> placeHolders;

	public BaseException() {
		errorCodes = new HashMap<String, String>();
		placeHolders = new HashMap<String, String>();
	}

	public Set<String> getErrorCodes() {
		return errorCodes.keySet();
	}

	public void addErrorCode(String errorCode) {
		errorCodes.put(errorCode, "");
	}

	public void addErrorCode(String errorCode, String message) {
		addOrAppendCode(this.errorCodes, errorCode, message);
	}

	private void addOrAppendCode(Map<String, String> store, String errorCode,
			String message) {
		String value = hasValue(errorCodes, errorCode);
		// check if the error is already existing
		if (null == value) {
			value = message;
		} else {
			value = new StringBuffer(value).append(",").append(message)
					.toString();

		}
		errorCodes.put(errorCode, value);
	}

	public void addPlaceHolders(String errorCode, String placeHolder) {
		addOrAppendCode(this.placeHolders, errorCode, placeHolder);
	}

	private String hasValue(Map<String, String> store, String key) {
		return store.get(key);
	}

	/**
	 * Method to compose an error message String by picking values related to
	 * each error Code. If an error code has a message associated with it then
	 * that is picked else default message from message bundle is picked.
	 * Also placeHolder map is checked to verify if any placeholders are to be
	 * replaced with some data 
	 * 
	 * @return String comma seperated error Message String.
	 */
	public String getErrorMessage() {
		return null;
	}

}
