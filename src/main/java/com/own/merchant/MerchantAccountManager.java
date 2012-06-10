package com.own.merchant;

import com.own.merchant.model.MerchantAccount;
import com.own.service.exception.DatabaseException;
import com.own.transaction.enums.MerchantAccountStatus;

public interface MerchantAccountManager {

	public MerchantAccount getMerchantAccountByID(String merchantID);
	
	public void saveMerchantAccountDetails(MerchantAccount account);
	
	public MerchantAccount createNewMerchantAccount();
	
	public MerchantAccountStatus getMerchantAccountStatus(MerchantAccount account);
	
	public void activateMerchantAccount(MerchantAccount account);
	
	public void deActivateMerchantAccount(MerchantAccount account);
	
	public void getReserveAmountForMerchantAccount(MerchantAccount account);
	
	/**
	 * Finds a merchant based on the account name. Does an exact match for the
	 * string
	 * 
	 * @param name
	 * @return
	 * @throws DatabaseException
	 */
	public MerchantAccount findAccountByAccountName(String name)
			throws DatabaseException;

	

	/**
	 * Persists a merchant account in the database
	 * 
	 * @param mAccount
	 * @return
	 * @throws DatabaseException
	 */
	public MerchantAccount saveMerchantAccount(MerchantAccount mAccount)
			throws DatabaseException;
	
}
