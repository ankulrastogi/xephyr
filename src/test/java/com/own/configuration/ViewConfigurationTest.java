package com.own.configuration;

import static junit.framework.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ViewResolver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ViewConfiguration.class},loader = TestContextLoader.class)
public class ViewConfigurationTest {
	@Autowired
	ViewResolver viewResolver;

	@Test
	public void check_view_resolver_not_null()
	{
		assertNotNull(viewResolver);
	}
}
