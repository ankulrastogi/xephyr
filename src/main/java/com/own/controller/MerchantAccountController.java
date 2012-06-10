package com.own.controller;

import java.util.ArrayList;
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
import com.own.merchant.model.Merchant;
import com.own.merchant.model.MerchantAccount;
import com.own.merchant.model.ServiceResponse;
import com.own.service.MerchantAccountService;
import com.own.service.MerchantRegistrationService;
import com.own.service.MerchantService;
import com.own.service.exception.ServiceException;
import com.own.service.exception.BaseException.ExceptionType;
import com.own.transaction.enums.MerchantStatus;

/**
 * REST based controller to handle multiple merchant accounts for a merchant
 * 
 * @author ankul
 * 
 */
@Controller
@RequestMapping("/service/merchant")
public class MerchantAccountController extends BaseController {

	private static Logger logger = Logger
			.getLogger(MerchantAccountController.class);

	@Autowired
	MerchantService mService;
	
	@Autowired
	MerchantAccountService maService;

	@Autowired
	MerchantRegistrationService merchantRegistrationService;

	/**
	 * REST service to create a merchant account. Account can only be created
	 * for merchants which are in ACTIVE state. Merchant account will only be
	 * created in PENDING state, and should only be activated by the system
	 * admin after he process is completed.
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/{merchID}/account" }, method = RequestMethod.POST)
	public @ResponseBody
	ServiceResponse createMerchantAccount(
			@PathVariable("merchID") String merchatnUserID,
			@RequestBody MerchantAccount mAccount) {
		Map<String, List<String>> messages = new HashMap<String, List<String>>();
		try {
			Merchant merchant = mService
					.getMerchantByMerchantUserID(merchatnUserID);
			if (!merchant.getStatus().equals(MerchantStatus.ACTIVE)) {
				messages.put(
						String.valueOf(ErrorConstants.MERCHANT_NOT_ACTIVE),
						new ArrayList<String>());
				return ServiceUtils.composeServiceResponse(
						ServiceConstants.FAIL, messages, null);
			}
			// check if the merchant Account name given is null
			if (null == mAccount.getName()
					|| mAccount.getName().trim().length() == 0) {
				return ServiceUtils.composeServiceResponse(
						ServiceConstants.FAIL,
						String.valueOf(ErrorConstants.FIELD_EMPTY),
						"Merchant Account name cannot be null", null);
			}
			mAccount = maService.createAccountForMerchant(mAccount, merchant);

		} catch (ServiceException e) {
			messages = convertorfactory.convertExceptionMessages(e
					.getAllErrorMessages(ExceptionType.VIEW));
			e.printStackTrace();
			return ServiceUtils.composeServiceResponse(ServiceConstants.FAIL,
					messages, null);
		}
		logger.info("Merchant Account:" + mAccount);
		return ServiceUtils.composeServiceResponse(ServiceConstants.SUCCESS,
				new HashMap<String, List<String>>(), mAccount);

	}

	/**
	 * de-activates all merchant accounts for a merchantID. Account which are
	 * activated will be skipped
	 */
	@RequestMapping(value = "/{merchID}/deactivate/_all", method = RequestMethod.POST)
	public String deActivateAllMerchantAccount(
			@PathVariable("merchID") String merchantID) {
		return null;
	}

	/**
	 * de-activate a merchant account.
	 */
	@RequestMapping(value = "/{merchID}/deactivate/{id}", method = RequestMethod.POST)
	public String deActivateDirectMerchantAccount(
			@PathVariable("merchID") String merchantUserID,
			@PathVariable("id") String accountID) {
		return null;
	}

	/**
	 * Activate a merchant account
	 */
	@RequestMapping(value = "/{merchID}/activate/{id}", method = RequestMethod.POST)
	public String activateMerchantAccount(
			@PathVariable("merchID") String merchantUserID,
			@PathVariable("id") String accountID) {
		return null;
	}

	/**
	 * Activate all merchant accounts associated with a merchantID. Those which
	 * are active will be ignored
	 */
	@RequestMapping(value = "/{merchID}/activate/_all", method = RequestMethod.POST)
	public String activateDirectMerchantAccount(
			@PathVariable("merchID") String merchantUserID,
			@PathVariable("merchID") String merchantID) {
		return null;
	}

	/**
	 * Deletes a merchant account
	 * 
	 */
	@RequestMapping(value = "/{merchID}/delete/{id}", method = RequestMethod.POST)
	public String deleteAccount(@PathVariable("merchID") String merchantUserID,
			@PathVariable("id") String accountID) {
		return null;
	}

	/**
	 * Updates a merchant account
	 * 
	 */
	@RequestMapping(value = "/{merchID}/update/{id}", method = RequestMethod.POST)
	public String updateAccount(@PathVariable("merchID") String merchantUserID,
			@PathVariable("id") String accountID) {
		return null;
	}

}
