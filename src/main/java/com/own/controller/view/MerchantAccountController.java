package com.own.controller.view;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.own.common.constants.AppConstant;
import com.own.common.constants.ErrorConstants;
import com.own.controller.utils.ServiceConstants;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.MerchantAccount;
import com.own.merchant.model.view.form.AddAccountForm;
import com.own.service.MerchantAccountService;
import com.own.service.MerchantService;
import com.own.service.exception.ServiceException;
import com.own.transaction.enums.MerchantStatus;

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
		model.addAttribute("account", new AddAccountForm());
		return "people";
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String createAccount(
			@Valid @ModelAttribute("account") AddAccountForm accForm,BindingResult result,Model model,
			HttpServletRequest request) {
		logger.info("About to add merchant account");
		MerchantAccount account = accForm.buildMerchantAccount();
		if (null == accForm.getAccountName()
				|| accForm.getAccountName().trim().length() == 0) {
			addError(request, ErrorConstants.AUTHENTICATION_FAILED);

			addError(request, ErrorConstants.ACTIVATION_EXPIRED);
			model.addAttribute(AppConstant.POPUP_PARAM,Boolean.TRUE);
			return "people";
		}

		Merchant merchant;
		try {
			merchant = mService.getMerchantByMerchantUserID(accForm
					.getMerchantID());
			if(!merchant.getStatus().equals(MerchantStatus.ACTIVE))
			{
				addError(request, ErrorConstants.MERCHANT_NOT_ACTIVE);
				model.addAttribute(AppConstant.POPUP_PARAM,Boolean.TRUE);
				return "people";
			}
			maService.createAccountForMerchant(account, merchant);
			request.setAttribute(ServiceConstants.SUCCESS_MESSAGE_KEY,
					String.valueOf(ErrorConstants.MERCHANT_ACCOUNT_CREATE_SUCCESS));

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "people";
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
