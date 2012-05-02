package com.own.controller;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.own.controller.utils.ServiceConstants;
import com.own.controller.utils.ServiceUtils;
import com.own.merchant.manager.MerchantValidator;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.MerchantRegistration.ValidationType;
import com.own.merchant.model.ServiceResponse;
import com.own.service.MerchantRegistrationService;
import com.own.service.MerchantService;
import com.own.service.exception.DuplicateValueException;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.MerchantValidationException;
import com.own.service.exception.ServiceException;

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

	@Autowired
	MerchantValidator validator;

	@Autowired
	MerchantRegistrationService merchantRegistrationService;

	/**
	 * Add the specified merchant to the system
	 * 
	 * @return ServiceResponse - standard service response
	 * @throws DuplicateValueException
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody
	ServiceResponse registerMerchant(@RequestBody MerchantRegistration rMerchant) {
		MerchantRegistration register = null;
		ServiceResponse resp = null;

		try {
			merchantRegistrationService.validate(rMerchant,
					ValidationType.SIGNUP);

			register = merchantRegistrationService.registerMerchant(rMerchant);

		} catch (ServiceException e) {
			resp = ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					e.getErrorMessages(), null);
			return resp;
		}

		resp = ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, String>(), register);

		return resp;
	}

	/**
	 * Activates a new merchant.
	 */
	@RequestMapping(value = { "/activate/{id}/{activationURL}" }, method = RequestMethod.GET)
	public @ResponseBody
	ServiceResponse activateRegistration(@PathVariable("id") String emailID,
			@PathVariable("activationURL") String identifier) {
		if (null == emailID || null == identifier)
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					"Invalid request", null);
		MerchantRegistration rMerchant = null;

		try {
			rMerchant = merchantRegistrationService.activateRegistration(
					emailID, identifier);
		} catch (ServiceException e) {

			e.printStackTrace();
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					e.getErrorMessages(), null);

		}
		return ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, String>(), rMerchant);
	}

	/**
	 * On boards a merchant in the system. Entry moves from registration table
	 * to merchant table. Merchant will initially be in a PENDING state
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/onboard/{id}" }, method = RequestMethod.GET)
	public @ResponseBody
	ServiceResponse makeMerhchantOnBoard(@PathVariable("id") String emailID) {
		if (null == emailID)
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					"Invalid EmailID.Cannot onboard", null);

		MerchantRegistration registered = merchantRegistrationService
				.getRegistrationByEmail(emailID);
		if (null == registered)
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					"No registration for the given email.Cannot onboard", null);

		Merchant merchant = mapRegistrationToMerchant(registered,
				new Merchant());

		try {
			merchant = mService.createMerchant(merchant);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					"Error in Service", null);
		}

		return ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, String>(), merchant);
	}

	private Merchant mapRegistrationToMerchant(MerchantRegistration registered,
			Merchant merchant) {
		merchant.setEmailID(registered.getEmail());
		merchant.setName(registered.getName());
		return merchant;

	}

	/**
	 * Configure a merchant within the system. This is when a shared key will be
	 * generated After this only the merchant will be able to add the account
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

	/**
	 * Validate merchant credentials and login the merchant if he is
	 * authenticated. Not sure whether it should redirect to a view or something
	 */
	public void loginMerchant(@RequestBody Merchant merchant) {
		try {
			if (mService.authenticate(merchant)) {
				logger.info("Merchant successfully authenticated");

			} else {
				logger.info("Merchant cannot be authenticated");

			}

		} catch (MerchantValidationException e) {
			logger.info("The credentials/details provided by the merchant are not valid");
			e.printStackTrace();
		} catch (IllegalObjectStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
