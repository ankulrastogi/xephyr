package com.own.merchant;

import com.own.merchant.model.Merchant;
import com.own.service.exception.IllegalObjectStateException;
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

	/**
	 * Gets the merchant information from the database based on the emailID
	 * 
	 * @param emailID
	 * @return
	 */
	public Merchant getMerchantByEmail(String emailID);

	public Merchant saveMerchant(Merchant merchant)
			throws IllegalObjectStateException;

	public void saveMerchantDetails(Merchant merchant);

	public MerchantAccount createNewMerchantAccount();

	public MerchantStatus getMerchantStatus(Merchant merchant);

	public void activateMerchant(Merchant merchant);

	public void deActivateMerchant(Merchant merchant);

	public void getReserveAmountForMerchant(Merchant merchant);

	public void getLedgerForMerchant(Merchant merchant);

}
