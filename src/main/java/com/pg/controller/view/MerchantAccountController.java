package com.pg.controller.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.own.merchant.model.Merchant;
import com.own.merchant.model.MerchantAccount;
import com.own.merchant.model.view.form.MerchantAccountForm;
import com.own.service.MerchantAccountService;
import com.own.service.MerchantService;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.ServiceException;
import com.own.transaction.enums.MerchantStatus;
import com.pg.common.constant.AppConstant;
import com.pg.common.constant.MessageCodeConstant;
import com.pg.common.constant.ServiceConstants;

@Controller(value = "merchantAccountViewController")
@RequestMapping("/view/merchant/account")
public class MerchantAccountController extends BaseController {

	@Autowired
	MerchantAccountService maService;

	@Autowired
	MerchantService mService;

	private static Logger logger = Logger
			.getLogger(MerchantAccountController.class);

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public String setupCreatePage(Model model) {
		model.addAttribute("account", new MerchantAccountForm());
		return "people";
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String createAccount(
			@Valid @ModelAttribute("account") MerchantAccountForm accForm,
			BindingResult result, Model model, HttpServletRequest request) {
		logger.info("About to add merchant account");
		MerchantAccount account = accForm.buildMerchantAccount();
		if (null == accForm.getAccountName()
				|| accForm.getAccountName().trim().length() == 0) {
			addError(request, MessageCodeConstant.AUTHENTICATION_FAILED);
			model.addAttribute(AppConstant.POPUP_PARAM, Boolean.TRUE);
			return "people";
		}

		Merchant merchant;
		try {
			merchant = mService.getMerchantByMerchantUserID(accForm
					.getMerchantID());
			if (!merchant.getStatus().equals(MerchantStatus.ACTIVE)) {
				addError(request, MessageCodeConstant.MERCHANT_NOT_ACTIVE);
				model.addAttribute(AppConstant.POPUP_PARAM, Boolean.TRUE);
				return "people";
			}
			maService.createAccountForMerchant(account, merchant);

			request.setAttribute(ServiceConstants.SUCCESS_MESSAGE_KEY, String
					.valueOf(MessageCodeConstant.MERCHANT_ACCOUNT_CREATE_SUCCESS));

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addError(request, MessageCodeConstant.GENERAL_ERROR);
		}

		return "people";
	}

	@RequestMapping(value = { "/{merchID}/{accountID}/edit" }, method = RequestMethod.GET)
	public String setupEditAccountsPage(
			@PathVariable("merchID") String merchantID,
			@PathVariable("accountID") String accountID, Model model,
			HttpServletRequest request) {
		model.addAttribute("editAccountForm", new MerchantAccountForm());
		model.addAttribute("merchantID", merchantID);
		model.addAttribute("accountID", accountID);
		
		if (null == mService.accountBelongsToMerchant(merchantID, accountID)) {
			addError(request, MessageCodeConstant.ACCOUNT_MERCHANT_MISMATCH);
			return "editAccount";
		}

		return "editAccount";
	}

	@RequestMapping(value = { "/{merchID}/{accountID}/edit" }, method = RequestMethod.POST)
	public String editAccountsPage(
			@PathVariable("merchID") String merchantID,
			@PathVariable("accountID") String accountID,
			@Valid @ModelAttribute("editAccountForm") MerchantAccountForm editForm,
			BindingResult result, Model model, HttpServletRequest request) {
		MerchantAccount mAccount = null;
		if (null == (mAccount = mService.accountBelongsToMerchant(merchantID, accountID))) {
			addError(request, MessageCodeConstant.ACCOUNT_MERCHANT_MISMATCH);
			return "editAccount";
		}
		try {
			mAccount.setName(editForm.getAccountName());
			maService.updateMerchantAccount(mAccount);
			request.setAttribute(ServiceConstants.SUCCESS_MESSAGE_KEY, String
					.valueOf(MessageCodeConstant.MERCHANT_ACCOUNT_UPDATE_SUCCESS));
		} catch (ServiceException e) {
			
			e.printStackTrace();
			addError(request, MessageCodeConstant.GENERAL_ERROR);
		} catch (IllegalObjectStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addError(request, MessageCodeConstant.ACCOUNT_NAME_EXISTS);
		}
		
		return "editAccount";
	}

	@SuppressWarnings("unchecked")
	private void addError(HttpServletRequest request, Integer activationExpired) {

		List<String> errorCodesList = (List<String>) request
				.getAttribute(AppConstant.ERROR_MESSAGES_KEY);
		if (null == errorCodesList) {
			errorCodesList = new ArrayList<String>();
		}
		errorCodesList.add(String.valueOf(activationExpired));
		request.setAttribute(AppConstant.ERROR_MESSAGES_KEY, errorCodesList);
	}
}
