package com.own.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MessageConfiguration {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(new String[] {
				"classpath:messages/messages",
				"classpath:messages/error-messages" });
		messageSource.setCacheSeconds(10);
		return messageSource;
	}

	@Bean
	public MessageSource exceptionMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource
				.setBasenames(new String[] { "classpath:messages/exception-messages" });
		messageSource.setCacheSeconds(10);
		
		return messageSource;
	}
	@Bean
	public Validator validator()
	{
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		validator.setProviderClass(HibernateValidator.class);
		validator.setValidationPropertyMap(propertiesMap());
		return validator;
	}

	private Map<String, String> propertiesMap() {
		
		Map<String, String> propMap = new HashMap<String, String>();
		
		propMap.put("hibernate.validator.fail_fast", "false");
		return propMap;
	}

	
	
}
