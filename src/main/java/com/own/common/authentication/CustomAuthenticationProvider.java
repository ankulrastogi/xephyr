package com.own.common.authentication;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.own.merchant.model.Merchant;
import com.own.service.MerchantService;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.ServiceException;

@Component("dummyProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider{

	private static Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	MerchantService mService;
	
	@Override
	public Authentication authenticate(Authentication authToken)
			throws AuthenticationException {
		
			String username = String.valueOf(authToken.getPrincipal());
			String password = String.valueOf(authToken.getCredentials());
			Merchant dummy = new Merchant();
			dummy.setEmailID(username);
			dummy.setPassword(password);
			logger.info(username + " " + password);
			Merchant loginUser = null;
			try {
				loginUser = mService.loginUser(dummy);
				
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalObjectStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(null != loginUser)
			{
				authToken.setAuthenticated(true);
			}
		
		return authToken;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}