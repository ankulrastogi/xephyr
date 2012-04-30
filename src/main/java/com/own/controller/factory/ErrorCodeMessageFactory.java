package com.own.controller.factory;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class ErrorCodeMessageFactory {

	@Resource(name="errorCodes")
	Properties properties;
	
	public String getProperty(String key)
	{
		return properties.getProperty(key);
	}
	
}
