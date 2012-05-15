package com.own.service;

import org.springframework.transaction.annotation.Transactional;

import com.own.transaction.merchant.model.MerchantAccount;

public class MerchantAccountServiceImpl implements MerchantAccountService {
	
	@Transactional
	public MerchantAccount createAccount(MerchantAccount account) {
		
		return null;
	}

}
