package com.own.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.own.database.dao.MerchantAccountDAO;
import com.own.transaction.merchant.model.MerchantAccount;

public class MerchantAccountServiceImpl implements MerchantAccountService {

	@Autowired
	MerchantAccountDAO mAccountDAO;
	
	@Transactional
	public MerchantAccount createAccount(MerchantAccount account) {
		
		return null;
	}

}
