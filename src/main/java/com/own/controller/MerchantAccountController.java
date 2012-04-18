package com.own.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * REST based controller to handle multiple merchant accounts for a merchant
 * 
 * @author ankul
 * 
 */
@Controller
@RequestMapping("/account")
public class MerchantAccountController {

	private static Logger logger = Logger.getLogger(MerchantAccountController.class);
	
	/**
	 * Adds a merchant Account to the specified merchant
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public String addAccount() {
		return null;
	}

	/**
	 * de-activates all merchant accounts for a merchantID. Account which are
	 * activated will be skipped
	 */
	@RequestMapping(value = "/deactivate/{merchID}/_all", method = RequestMethod.POST)
	public String deActivateAllMerchantAccount(
			@PathVariable("merchID") String merchantID) {
		return null;
	}

	/**
	 * de-activate a merchant account.
	 */
	@RequestMapping(value = "/deactivate/{id}", method = RequestMethod.POST)
	public String deActivateDirectMerchantAccount(
			@PathVariable("id") String accountID) {
		return null;
	}

	/**
	 * Activate a merchant account
	 */
	@RequestMapping(value = "/activate/{id}", method = RequestMethod.POST)
	public String activateMerchantAccount(@PathVariable("id") String accountID) {
		return null;
	}

	/**
	 * Activate all merchant accounts associated with a merchantID. Those which
	 * are active will be ignored
	 */
	@RequestMapping(value = "/activate/{merchID}/_all", method = RequestMethod.POST)
	public String activateDirectMerchantAccount(
			@PathVariable("merchID") String merchantID) {
		return null;
	}

	/**
	 * Deletes a merchant account
	 * 
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteAccount(@PathVariable("id") String accountID) {
		return null;
	}

	/**
	 * Updates a merchant account
	 * 
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateAccount(@PathVariable("id") String accountID) {
		return null;
	}

}
