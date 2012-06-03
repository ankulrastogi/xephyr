package com.own.controller.view;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.own.controller.factory.MessageConvertorFactory;
import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.view.form.MerchantLoginForm;
import com.own.merchant.model.view.form.NewRegistrationFormModel;
import com.own.service.MerchantRegistrationService;
import com.own.service.MerchantService;
import com.own.service.exception.ServiceException;

@Controller(value = "merchantViewController")
@RequestMapping("/view/merchant")
public class MerchantController extends BaseController {

	@Autowired
	MerchantService mService;

	@Autowired
	MessageConvertorFactory convertorFactory;

	@Autowired
	MerchantRegistrationService registrationService;

	private static Logger logger = Logger.getLogger(MerchantController.class);

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String loginPage(Model model) {
		logger.info("Adding login Model");
		model.addAttribute("loginModel", new MerchantLoginForm());
		return "login";
	}

	@Autowired
	@Qualifier(value="authManager")
	AuthenticationManager authManager;


	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String doLogin(
			@Valid @ModelAttribute("loginModel") MerchantLoginForm loginModel,
			BindingResult result, Model model) {
		
		
		if (result.hasErrors()) {
			logger.info("ERROR:" + result.toString());
			return "login";
		}
		
		List<String> errorList = new ArrayList<String>();
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				loginModel.getUserName(), loginModel.getPassword());
		
		token = (UsernamePasswordAuthenticationToken) authManager.authenticate(token);
		if(!token.isAuthenticated())
		{
			logger.info("authentication Failed");
			errorList.add("merchant.authentication.exception");
		}
		else
		{
			SecurityContextHolder.getContext().setAuthentication(token);
			return "redirect:groupList.html";
		}

		return "login";
	}

	@RequestMapping(value = { "/createaccount" }, method = RequestMethod.GET)
	public String createUserAccountGET(Model model) {
		model.addAttribute("registrationFormModel",
				new NewRegistrationFormModel());
		return "createaccount";
	}

	@RequestMapping(value = { "/createaccount" }, method = RequestMethod.POST)
	public String createUserAccountGET(
			@Valid @ModelAttribute("registrationFormModel") NewRegistrationFormModel formModel,
			BindingResult result, Model model) {
		String viewName = "createaccount";
		if (result.hasErrors())
			return viewName;
		MerchantRegistration rMerchant = formModel.convertToRegistration();
		try {
			rMerchant = registrationService.registerMerchant(rMerchant);

			if (rMerchant.getSignUpID() == null) {
				logger.info("There was some problem in saving the registration details.Please try again later");
				return viewName;
			}

			registrationService.activateRegistration(rMerchant);

			mService.moveMerchantOnBoard(rMerchant.getEmail());
			viewName = "redirect:login.html";
			// TODO: this will be handled later
			// registrationService.sendActivationLink(rMerchant);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return viewName;
	}
	
	@RequestMapping(value={"groupList"},method=RequestMethod.GET)
	public String postLoginPage(Model model)
	{
		return "groupList";
	}
}
