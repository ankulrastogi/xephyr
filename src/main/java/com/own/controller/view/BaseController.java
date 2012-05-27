package com.own.controller.view;

public class BaseController {

	private final String REDIRECT = "redirect:";
	
	protected String getInternalRedirect(String controllerName)
	{
		
		return REDIRECT + controllerName;
	}
	
	protected String getInternalRedirect(String controllerName,String queryString)
	{
		
		return REDIRECT + controllerName + "?" + queryString;
	}
}
