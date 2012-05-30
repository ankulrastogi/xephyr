package com.own.controller.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.own.controller.factory.MessageConvertorFactory;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.view.form.MerchantLoginForm;
import com.own.merchant.model.view.form.NewRegistrationFormModel;
import com.own.service.MerchantService;
import com.own.service.exception.BaseException.ExceptionType;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.ServiceException;

@Controller(value = "merchantViewController")
@RequestMapping("/view/merchant")
public class MerchantController extends BaseController {

	@Autowired
	MerchantService mService;

	@Autowired
	MessageConvertorFactory convertorFactory;

	private static Logger logger = Logger.getLogger(MerchantController.class);

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String loginPage(Model model) {
		logger.info("Adding login Model");
		model.addAttribute("loginModel",new MerchantLoginForm());
		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("loginModel") MerchantLoginForm loginModel,BindingResult result,
			Model model) {
		if(result.hasErrors())
		{
			logger.info("ERROR:" + result.toString());
			
			return "login";
		}
		Merchant merchant = new Merchant();
		merchant.setEmailID(loginModel.getUserName());
		merchant.setPassword(loginModel.getPassword());
		List<String> errorList = new ArrayList<String>();

		try {
			Merchant loginUser = mService.loginUser(merchant);
			if (null == loginUser) {
				logger.info("authentication Failed");
				errorList.add("merchant.authentication.exception");

			}
		} catch (IllegalObjectStateException e) {

			logger.info("Object validation failed:"
					+ e.getAllErrorMessages(ExceptionType.ALL));
			Map<String, List<String>> convertExceptionMessages = convertorFactory
					.convertExceptionMessages(e
							.getAllErrorMessages(ExceptionType.VIEW));
			errorList.addAll(convertorFactory
					.convertToList(convertExceptionMessages));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			logger.info("Service Exception:"
					+ e.getAllErrorMessages(ExceptionType.ALL));
			Map<String, List<String>> convertExceptionMessages = convertorFactory
					.convertExceptionMessages(e
							.getAllErrorMessages(ExceptionType.VIEW));
			errorList.addAll(convertorFactory
					.convertToList(convertExceptionMessages));
		}
		if (errorList.size() == 0) {
			return "login";
		}

		return "login";
	}

	@RequestMapping(value={"/createaccount"},method=RequestMethod.GET)
	public String createUserAccountGET(Model model)
	{
		model.addAttribute("registrationFormModel",new NewRegistrationFormModel());
		return "createaccount";
	}
	
	@RequestMapping(value={"/createaccount"},method=RequestMethod.POST)
	public String createUserAccountGET(@ModelAttribute("registrationFormModel")  NewRegistrationFormModel formModel, Model model)
	{
		
		return "createaccount";
	}
}
