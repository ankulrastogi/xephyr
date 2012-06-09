package com.own.transaction.merchant;

import com.own.merchant.model.MerchantAccount;
import com.own.transaction.enums.MerchantAccountStatus;

public interface MerchantAccountManager {

	public MerchantAccount getMerchantAccountByID(String merchantID);
	
	public void saveMerchantAccountDetails(MerchantAccount account);
	
	public MerchantAccount createNewMerchantAccount();
	
	public MerchantAccountStatus getMerchantAccountStatus(MerchantAccount account);
	
	public void activateMerchantAccount(MerchantAccount account);
	
	public void deActivateMerchantAccount(MerchantAccount account);
	
	public void getReserveAmountForMerchantAccount(MerchantAccount account);
	
	
}
