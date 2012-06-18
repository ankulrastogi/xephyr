package com.pg.spring.extension.url.configuration;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class CustomURLBasedViewResolver extends UrlBasedViewResolver{

	@Override
	protected View createView(String viewName, Locale locale) throws Exception {
		
		 View element = super.createView(viewName, locale);
		 if(element instanceof RedirectView)
		 {
			 RedirectView redirectView = (RedirectView)element;
			 
			redirectView.setExposeModelAttributes(false);
		 }
			 
		 return element;
	}
	
	
}
