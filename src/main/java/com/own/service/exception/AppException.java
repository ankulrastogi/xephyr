package com.own.service.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * General exception that will be thrown to the BL layer. The exception should concat all the 
 * exception codes that have been encountered during bubbling up
 * @author ankul
 *
 */
public class AppException extends Exception {

	private List<String> exceptionCodes = new ArrayList<String>();;
	
	private List<String> message = new ArrayList<String>();;
	
	
	public AppException(String exceptionCode,String message) {
		this.exceptionCodes.add(exceptionCode);
		this.message.add(message);
	
	}
	public void addToList(String exceptionCode,String message)
	{
		this.exceptionCodes.add(exceptionCode);
		this.message.add(message);
	
	}
	
	public List<String> getExceptionCodes()
	{
		return this.exceptionCodes;
	}
	
	public List<String> getMessages()
	{
		return this.message;
	}
}
