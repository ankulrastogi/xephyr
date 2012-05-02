package com.own.service;

import com.own.transaction.merchant.model.MerchantAccount;

/**
 * Service to handle merchant account related information
 * @author Ankul.Rastogi
 *
 */
public interface MerchantAccountService {

	public MerchantAccount createAccount(MerchantAccount account);
}