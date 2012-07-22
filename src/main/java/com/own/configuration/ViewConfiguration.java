package com.own.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;

import com.pg.spring.extension.url.configuration.CustomURLBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan({"com.pg.controller"})
public class ViewConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	Validator validator;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		ResourceHandlerRegistration addResourceHandler = registry.addResourceHandler("/resources/**");
		addResourceHandler.addResourceLocations("/resources/");
		addResourceHandler.setCachePeriod(0);
	}
	
	@Override
	public Validator getValidator()
	{
		return validator;
	}
	@Bean
	public ViewResolver viewResolver()
	{
		CustomURLBasedViewResolver viewResolver = new CustomURLBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer()
	{
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[]{"/WEB-INF/tiles.xml"});
		return configurer;
		
	}
	
	@Bean
	public LocaleResolver localeResolver()
	{
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.US);
		return resolver;
	}
	
}
