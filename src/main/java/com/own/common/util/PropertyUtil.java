package com.own.common.util;

import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class PropertyUtil {

	public enum PropertyType {
		SERVICE, ERROR, MESSAGE, CREDENTIAL
	}

	@Autowired
	@Qualifier(value = "environmentProperties")
	private Properties serviceProperties;
	
	@Autowired
	@Qualifier(value = "dltProperties")
	private Properties credentialProperties;

	@Autowired
	@Qualifier(value = "exceptionMessageSource")
	private MessageSource exceptionMessageSource;

	private Properties messageProperties;

	private String getErrorProperty(final String key) {

		return exceptionMessageSource
				.getMessage(key, null, Locale.getDefault());
	}

	private String getMessageProperty(final String key) {

		return messageProperties.getProperty(key);
	}

	public String getProperty(final PropertyType type, final String key) {
		if (null == type || null == key) {
			return null;
		}
		String value = null;
		switch (type) {
		case SERVICE:
			value = getServiceProperty(key);
			break;
		case ERROR:
			value = getErrorProperty(key);
			break;
		case MESSAGE:
			value = getMessageProperty(key);
			break;
		case CREDENTIAL:
			value = getCredentialProperty(key);
			break;
		default:
			break;
		}
		return value;
	}

	private String getServiceProperty(final String propertyKey) {

		return serviceProperties.getProperty(propertyKey);
	}
	
	private String getCredentialProperty(final String propertyKey) {

		return credentialProperties.getProperty(propertyKey);
	}

}
