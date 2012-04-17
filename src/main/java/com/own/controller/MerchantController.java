
package com.own.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.own.merchant.model.Merchant;
import com.own.service.MerchantService;
import com.own.service.exception.DuplicateValue;

@Controller	
@RequestMapping("/merchant")
public class MerchantController {

	private Logger logger = Logger.getLogger(MerchantController.class);
	
	@Autowired
	MerchantService mService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addMerchant()
	{
		Merchant merchant = new Merchant();
		merchant.setName("ankul");
		logger.info("Hello");
		try {
			mService.createMerchant(merchant);
		} catch (DuplicateValue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}
}
