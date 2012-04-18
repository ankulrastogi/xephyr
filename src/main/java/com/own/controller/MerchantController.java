package com.own.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.own.service.MerchantService;

/**
 * REST based controller to handle all the merchant related requests.
 * Add,delete,update
 * 
 * @author ankul
 * 
 */
@Controller
@RequestMapping("/merchant")
public class MerchantController {

	private Logger logger = Logger.getLogger(MerchantController.class);

	@Autowired
	MerchantService mService;

	/**
	 * Add the specified merchant to the system
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addMerchant() {
		return null;
	}

	/**
	 * Configure a merchant withing the system. This is when a shared key will
	 * be generated After this only the merchant will be able to add the account
	 * details.
	 * 
	 */
	@RequestMapping(value = "/configure/{id}", method = RequestMethod.POST)
	public String configureMerchant(@PathVariable("id") String merchantID) {
		return null;
	}

	/**
	 * De-activates a specified merchant from the system. A merchant is never
	 * deleted from the system
	 */
	@RequestMapping(value = "/deactivate/{id}", method = RequestMethod.POST)
	public String deActivateMerchant(@PathVariable("id") String merchantID) {
		return null;
	}

	/**
	 * Activates a specified merchant from the system. A merchant is never
	 * deleted from the system
	 */
	@RequestMapping(value = "/activate/{id}", method = RequestMethod.POST)
	public String activateMerchant(@PathVariable("id") String merchantID) {
		return null;
	}

	/**
	 * Update merchant details. NOt all details can updated by the merchant Some
	 * details will be leading the merchant to be in suspending state, pending
	 * verification.
	 * 
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateMerchant(@PathVariable("id") String merchantID) {
		return null;
	}

	/**
	 * Get merchant details
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.POST)
	public String getMerchantDetails(@PathVariable("id") String merchantID) {
		return null;
	}

}
