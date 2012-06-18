package com.pg.spring.extension.authentication.detailservice;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.own.merchant.MerchantManager;
import com.own.merchant.model.Merchant;
import com.own.service.exception.DatabaseException;

@Component("customUserService")
public class UserDetailServiceImpl implements UserDetailsService {

	private static Logger logger = Logger
			.getLogger(UserDetailServiceImpl.class);

	@Autowired
	MerchantManager mManager;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails user = null;
		try {

			Merchant merchant = mManager.getMerchantByEmail(username);
			user = new User(
					merchant.getEmailID(),
					merchant.getPassword(),
					true,
					true,
					true,
					true,
					Arrays.asList(new SimpleGrantedAuthority[] { new SimpleGrantedAuthority(
							"ROLE_ADMIN") }));

		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			logger.info("Error in getting user information:" + e.getMessage());
			throw new UsernameNotFoundException(e.getMessage());
		}

		return user;
	}

}
