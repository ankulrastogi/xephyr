package com.own.configuration;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.test.context.support.AbstractContextLoader;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

class TestContextLoader extends AbstractContextLoader
{

	@Override
	public ApplicationContext loadContext(
			MergedContextConfiguration mergedConfig) throws Exception {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setServletContext(new MockServletContext());
		context.register(mergedConfig.getClasses());
		context.refresh();
		AnnotationConfigUtils.registerAnnotationConfigProcessors((BeanDefinitionRegistry) context.getBeanFactory());
        context.registerShutdownHook();
	
		return context;
	}

	@Override
	public ApplicationContext loadContext(String... locations) throws Exception {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setServletContext(new MockServletContext());
		context.refresh();
		AnnotationConfigUtils.registerAnnotationConfigProcessors((BeanDefinitionRegistry) context.getBeanFactory());
        context.registerShutdownHook();
		return context;
	}

	@Override
	protected String getResourceSuffix() {
		// TODO Auto-generated method stub
		return "-root.xml";
	}
	
}