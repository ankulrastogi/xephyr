package com.own.controller.view;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.own.merchant.model.Merchant;
import com.own.merchant.model.MerchantAccount;
import com.own.merchant.model.view.form.AddAccountForm;
import com.own.service.MerchantAccountService;
import com.own.service.MerchantService;
import com.own.service.exception.ServiceException;

@Controller(value="merchantAccountViewController")
@RequestMapping("/view/merchant/account")
public class MerchantAccountController extends BaseController
{

	@Autowired
	MerchantAccountService maService;
	
	@Autowired
	MerchantService mService;
	
	private static Logger logger = Logger.getLogger(MerchantAccountController.class);
	
	@RequestMapping(value={"/create"},method=RequestMethod.POST)
	public String createAccount(@Valid @ModelAttribute("account") AddAccountForm accForm)
	{
		logger.info("About to add merchant account");
		MerchantAccount account = accForm.buildMerchantAccount();
		Merchant merchant;
		try {
			merchant = mService.getMerchantByMerchantUserID(accForm.getMerchantID());
			maService.createAccountForMerchant(account, merchant);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "people";
	}
}