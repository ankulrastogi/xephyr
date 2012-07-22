package com.pg.spring.extension.authentication;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.own.merchant.model.Merchant;
import com.own.service.MerchantService;
import com.own.service.exception.BaseException;
import com.own.service.exception.BaseException.ExceptionType;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.ServiceException;
import com.pg.controller.factory.MessageConvertorFactory;

//@Component(value = "customAuthProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static Logger logger = Logger
			.getLogger(CustomAuthenticationProvider.class);

	@Autowired
	MerchantService mService;

	@Autowired
	MessageConvertorFactory convertorfactory;

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

			throw new BadCredentialsException(getErrorMessage(e));
		} catch (IllegalObjectStateException e) {
			throw new BadCredentialsException(getErrorMessage(e));
		}
		UsernamePasswordAuthenticationToken token = null;
		if (null != loginUser) {
			token = new UsernamePasswordAuthenticationToken(
					username,
					password,
					Arrays.asList(new SimpleGrantedAuthority[] { new SimpleGrantedAuthority(
							"ROLE_ADMIN") }));
		}

		return token;
	}

	public String getErrorMessage(BaseException e) {
		Map<Integer, List<Object>> allErrorMessages = e
				.getAllErrorMessages(ExceptionType.VIEW);
		Map<String, List<String>> convertExceptionMessages = convertorfactory
				.convertExceptionMessages(allErrorMessages);
		StringBuffer buffer = new StringBuffer();
		for (String key : convertExceptionMessages.keySet()) {
			List<String> messageList = convertExceptionMessages.get(key);
			for (String message : messageList) {
				buffer.append(message).append("#");
			}
		}
		logger.info(buffer.toString());
		return buffer.toString();
	}

	@Override
	public boolean supports(Class<?> tokenClass) {
		// TODO Auto-generated method stub
		return tokenClass.equals(UsernamePasswordAuthenticationToken.class);
	}

}
