package com.own.controller.view;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.own.merchant.model.view.form.AddAccountForm;

@Controller(value="merchantAccountViewController")
@RequestMapping("/view/merchant/account")
public class MerchantAccountController extends BaseController
{

	private static Logger logger = Logger.getLogger(MerchantAccountController.class);
	
	@RequestMapping(value={"/create"},method=RequestMethod.POST)
	public String createAccount(@Valid @ModelAttribute("account") AddAccountForm accForm)
	{
		logger.info("About to add merchant account");
		return "grouplist";
	}
}
