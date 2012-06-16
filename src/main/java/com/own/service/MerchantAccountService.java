package com.own.service;

import com.own.merchant.model.Merchant;
import com.own.merchant.model.MerchantAccount;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.ServiceException;

/**
 * Service to handle merchant account related information
 * 
 * @author Ankul.Rastogi
 * 
 */
public interface MerchantAccountService {

	public MerchantAccount createAccount(MerchantAccount account);

	/**
	 * Creates a merchant account for a given merchant ID
	 * 
	 * @param mAccount
	 * @param merchant
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public MerchantAccount createAccountForMerchant(MerchantAccount mAccount,
			Merchant merchant) throws ServiceException;

	/**
	 * Activates a merchant account for provisioning in the system. No merchant
	 * can use the accounts that are not ACTIVE
	 * 
	 * @param mAccount
	 * @return
	 * @throws ServiceException
	 */
	public MerchantAccount activateAcccount(MerchantAccount mAccount)
			throws ServiceException;

	/**
	 * Update the merchant Account details
	 * 
	 * @param mAccount
	 * @return
	 * @throws IllegalObjectStateException
	 */
	public MerchantAccount updateMerchantAccount(MerchantAccount mAccount)
			throws ServiceException, IllegalObjectStateException;

	
	/**
	 * Removes an account from the merchant list . Account will be marked as disabled as of now.
	 * @param mAccount
	 * @throws ServiceException
	 */
	public void removeAccount(MerchantAccount mAccount) throws ServiceException;
}
