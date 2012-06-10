package com.own.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.own.common.constants.ErrorConstants;
import com.own.controller.utils.ServiceConstants;
import com.own.controller.utils.ServiceUtils;
import com.own.controller.view.BaseController;
import com.own.merchant.manager.MerchantValidator;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.MerchantRegistration.ValidationType;
import com.own.merchant.model.ServiceResponse;
import com.own.service.MerchantRegistrationService;
import com.own.service.MerchantService;
import com.own.service.exception.BaseException.ExceptionType;
import com.own.service.exception.DuplicateValueException;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.ServiceException;

/**
 * REST based controller to handle all the merchant related requests.
 * Add,delete,update
 * 
 * @author ankul
 * 
 */
@Controller
@RequestMapping("/service/merchant")
public class MerchantController extends BaseController {

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
			Map<String, List<String>> messages = convertorfactory
					.convertExceptionMessages(e
							.getAllErrorMessages(ExceptionType.VIEW));
			resp = ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					messages, null);
			return resp;
		}

		resp = ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, List<String>>(), register);

		return resp;
	}

	/**
	 * Gets the registration information based on email
	 * 
	 * @param emailID
	 * @return
	 */

	@RequestMapping(value = { "/register/email/{id}" }, method = RequestMethod.GET)
	public @ResponseBody
	ServiceResponse getRegistrationStatusByMail(
			@PathVariable("id") String emailID) {
		boolean errorFlag = false;

		if (null == emailID) {
			errorFlag = true;

		}

		MerchantRegistration registration = null;
		try {
			registration = merchantRegistrationService
					.getRegistrationByEmail(emailID);
		} catch (ServiceException e) {
			e.printStackTrace();
			errorFlag = true;
		}
		if (null == registration)
			errorFlag = true;
		if (errorFlag)
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					"Error in fetching information", null);

		return ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, List<String>>(), registration);
	}

	/**
	 * Activates a new merchant.ActivationURL is basically a 32 bit checksum
	 * generated to asceratain the user is correct.
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
			Map<String, List<String>> messages = convertorfactory
					.convertExceptionMessages(e
							.getAllErrorMessages(ExceptionType.VIEW));
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					messages, null);

		}
		return ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, List<String>>(), rMerchant);
	}

	/**
	 * On boards a merchant in the system. Entry moves from registration table
	 * to merchant table. Merchant will initially be in a INACTIVE state. Only
	 * registrations which are in ACTIVE state can be brought onboard
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/onboard/{id}" }, method = RequestMethod.GET)
	public @ResponseBody
	ServiceResponse makeMerhchantOnBoard(@PathVariable("id") String emailID) {
		if (null == emailID)
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					"Invalid EmailID.Cannot onboard", null);

		Merchant merchant = null;
		try {
			merchant = mService.moveMerchantOnBoard(emailID);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					"Error in Service", null);
		}

		return ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, List<String>>(), merchant);
	}

	/**
	 * De-activates a specified merchant from the system. A merchant is never
	 * deleted from the system
	 */
	@RequestMapping(value = "/deactivate/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ServiceResponse deActivateMerchant(@PathVariable("id") String merchantID) {
		if (null == merchantID)
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					"Invalid merchantID.", null);

		Merchant merchant = null;
		try {
			merchant = mService.deActivateMerchant(merchantID);
		} catch (ServiceException e) {
			e.printStackTrace();
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					"Error in Service", null);
		}

		return ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, List<String>>(), merchant);

	}

	/**
	 * Activates a specified merchant from the system. A merchant is never
	 * deleted from the system
	 */
	@RequestMapping(value = "/activate/{id}", method = RequestMethod.POST)
	public @ResponseBody
	ServiceResponse activateMerchant(@PathVariable("id") String merchantID) {
		Merchant merchant = null;
		try {
			merchant = mService.activateMerchant(merchantID);
		} catch (ServiceException e) {
			e.printStackTrace();
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					convertorfactory.convertExceptionMessages(e
							.getAllErrorMessages(ExceptionType.VIEW)), null);
		}

		return ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, List<String>>(), merchant);
	}

	/**
	 * Update merchant details. NOt all details can updated by the merchant Some
	 * details will be leading the merchant to be in suspending state, pending
	 * verification.
	 * 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	ServiceResponse updateMerchant(@RequestBody Merchant merchant) {

		Merchant result = null;
		try {
			result = mService.updateMerchant(merchant);
		} catch (ServiceException e) {
			Map<String, List<String>> messages = convertorfactory
					.convertExceptionMessages(e
							.getAllErrorMessages(ExceptionType.VIEW));
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					messages, null);

		}
		return ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, List<String>>(), result);
	}

	/**
	 * Get merchant details
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ServiceResponse getMerchantDetails(@PathVariable("id") String merchantUserID) {
		if (null == merchantUserID || merchantUserID.trim().length() == 0) {
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					String.valueOf(ErrorConstants.FIELD_EMPTY),
					"No Merchant User ID specified", null);
		}
		try {
			Merchant merchant = mService.getMerchantByMerchantUserID(merchantUserID);
			logger.info("Merchant Details:" + merchant);
			return ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS, new HashMap<String, List<String>>(), merchant);
		} catch (ServiceException e) {
			e.printStackTrace();
			Map<String, List<String>> messages = convertorfactory
					.convertExceptionMessages(e
							.getAllErrorMessages(ExceptionType.VIEW));
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					messages, null);
		}
	}

	/**
	 * Validate merchant credantials and login the merchant if he is
	 * authenticated. Not sure whether it should redirect to a view or something
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody
	ServiceResponse loginMerchant(@RequestBody Merchant merchant) {
		logger.info("Merchant INFO:" + merchant);
		Merchant loginUser = null;
		try {
			loginUser = mService.loginUser(merchant);
			if (null != loginUser) {
				logger.info("Merchant successfully authenticated");

			} else {
				logger.info("Merchant cannot be authenticated");

			}

		} catch (IllegalObjectStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String, List<String>> messages = convertorfactory
					.convertExceptionMessages(e
							.getAllErrorMessages(ExceptionType.VIEW));
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					messages, null);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map<String, List<String>> messages = convertorfactory
					.convertExceptionMessages(e
							.getAllErrorMessages(ExceptionType.VIEW));
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					messages, null);
		}

		return ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, List<String>>(), loginUser);

	}


}

