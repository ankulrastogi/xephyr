package com.own.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.own.service.MerchantService;

@Controller
@RequestMapping("/service")
public class BaseController {

	
	@RequestMapping(value = "/check",method=RequestMethod.GET)
	public String getWelcomeFile()
	{
		return "home";
	}
	
}	

