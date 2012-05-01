package com.own.controller.factory;

import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class ErrorCodeMessageFactory {

	
	private Properties properties;
	
	public String getProperty(String key)
	{
		return properties.getProperty(key);
	}
	
}
