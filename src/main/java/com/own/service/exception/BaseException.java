package com.own.service.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

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
	private Map<String, List<String>> errorCodes = new HashMap<String, List<String>>();

	private Map<String, List<String>> placeHolders = new HashMap<String, List<String>>();

	public BaseException() {

	}

	public BaseException(String errorCode) {
		addErrorCode(errorCode);
	}

	public BaseException(String errorCode, String message) {
		addErrorCode(errorCode, message);
	}

	public BaseException(String errorCode, String message, String[] placeHolders) {
		addErrorCode(errorCode, message);
		addPlaceHolders(errorCode, placeHolders);

	}
	
	public BaseException(String errorCode,String[] placeHolder)
	{
		addPlaceHolders(errorCode,placeHolder);
	}
	

	public Set<String> getErrorCodes() {
		return errorCodes.keySet();
	}

	/**
	 * Put an empty message for the error Code. For emapty message the default
	 * string from the properties file will be picked up.
	 * 
	 * @param errorCode
	 */
	public void addErrorCode(String errorCode) {
		addErrorCode(errorCode, "");
	}

	private List<String> getMessageList(String errorCode) {
		List<String> messageList = errorCodes.get(errorCode);

		if (null == messageList)
			messageList = new ArrayList<String>();
		return messageList;
	}

	/**
	 * Validates if the error Code requested is a valid error Code
	 * @param errorCode
	 */
	private boolean validErrorCode(String errorCode) {
		
		return false;

	}

	public void addErrorCode(String errorCode, String message) {
		validErrorCode(errorCode);

		if(!validErrorCode(errorCode) || null == message || message.trim().length() == 0)
			return;
		
		List<String> messageList = getMessageList(errorCode);
		messageList.add(message);
		errorCodes.put(errorCode, messageList);

	}

	public void addErrorMessage(String errorCode,String message,String[] placeHolder)
	{
		addErrorCode(errorCode, message);
		addPlaceHolders(errorCode, placeHolder);
	}
	public void addPlaceHolders(String errorCode, String[] placeHolder) {

		validErrorCode(errorCode);

		if(!validErrorCode(errorCode) || null == placeHolder || placeHolder.length == 0)
			return;
		
		List<String> placeHolders = getPlaceHolderList(errorCode);
		String placeHolderString = StringUtils.join(placeHolder, ",");
		placeHolders.add(placeHolderString);
		
		this.placeHolders.put(errorCode, placeHolders);

	}

	private List<String> getPlaceHolderList(String errorCode) {
		List<String> holderList = placeHolders.get(errorCode);

		if (null == holderList)
			holderList = new ArrayList<String>();
		return holderList;
	}


	/**
	 * Method to compose an error message String by picking values related to
	 * each error Code. If an error code has a message associated with it then
	 * that is picked else default message from message bundle is picked. Also
	 * placeHolder map is checked to verify if any placeholders are to be
	 * replaced with some data
	 * 
	 * @return String comma seperated error Message String.
	 */
	public String getErrorMessage() {
		return null;
	}

}
