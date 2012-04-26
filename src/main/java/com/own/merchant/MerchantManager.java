package com.own.merchant;

import com.own.merchant.manager.MerchantValidatorImpl.ValidationType;
import com.own.merchant.model.Merchant;
import com.own.transaction.enums.MerchantStatus;

import com.own.transaction.merchant.model.MerchantAccount;

public interface MerchantManager {

	public Merchant getMerchantByID(String merchantID);
	
	/**
	 * Checks if the merchant email ID is already present in the system.
	 * 
	 * @param mEmailID
	 * @return boolean
	 */
	public boolean checkMerchantByEmail(String mEmailID);
	
	public Merchant saveMerchant(Merchant merchant);
	
	public void saveMerchantDetails(Merchant merchant);
	
	public MerchantAccount createNewMerchant();
	
	public MerchantStatus getMerchantStatus(Merchant merchant);
	
	public void activateMerchant(Merchant merchant);
	
	public void deActivateMerchant(Merchant merchant);
	
	public void getReserveAmountForMerchant(Merchant merchant);
	
	public void getLedgerForMerchant(Merchant merchant);

	/**
	 * This method checks if the merchant is valid or not.
	 * A Merchant is checked for validaity in two cases.
	 * Pre-persitance - Merchant is checked if the mandatory values are present(email,name,details,username/password etc)
	 * Post-persistance - Apart from pre-persistance checks it should have shared key,unique Merchant ID).
	 * Should delegate call to MerchantValidator to get the desired information
	 * @param merchant
	 * @return
	 */
	public boolean isValidMerchant(Merchant merchant,ValidationType type);

	
	
	
}
