package com.own.service.exception;


/**
 * Exception for the case if a duplicate value is observed to be existing.
 * @author ankul
 *
 */
public class DuplicateValue extends Exception {

	private Object dupValue;
	
	public DuplicateValue(Object dupValue) {
		this.dupValue = dupValue;
	}
	
	public Object getDuplicateValue()
	{
		return dupValue;
	}
	
}
