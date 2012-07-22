package com.own.configuration;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MessageConfiguration.class})
public class MessageSourceConfigurationTest {

	
	@Autowired
	MessageSource messageSource;
	
	@Test
	public void check_message_source_not_null()
	{
	
		assertNotNull(messageSource);
		assertNotNull(messageSource.getMessage("dlt.form.submit",null, Locale.US));
		System.out.println(messageSource.getMessage("dlt.form.submit",null, Locale.US));
	}
}
