package com.own.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/service")
public class BaseController {

	private Logger logger = Logger.getLogger(BaseController.class);
	
	@RequestMapping(value = "/check",method=RequestMethod.GET)
	public String getWelcomeFile()
	{
		logger.info("in Home");
		return "home";
	}
	
}	

