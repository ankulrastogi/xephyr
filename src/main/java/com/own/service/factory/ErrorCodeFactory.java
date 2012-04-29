package com.own.service.factory;

import org.springframework.stereotype.Component;

@Component
public class ErrorCodeFactory {

	
	private static class Instance
	{
		public static ErrorCodeFactory instance = new ErrorCodeFactory();
	}
	
	private ErrorCodeFactory()
	{
		
	}
	
	public static ErrorCodeFactory getInstance()
	{
		return Instance.instance;
	}
 
}
