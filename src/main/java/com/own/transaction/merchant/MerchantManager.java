package com.own.transaction.merchant;

import com.own.transaction.enums.MerchantStatus;
import com.own.transaction.merchant.model.Merchant;
import com.own.transaction.merchant.model.MerchantAccount;

public interface MerchantManager {

	public Merchant getMerchantByID(String merchantID);
	
	public void saveMerchantDetails(Merchant merchant);
	
	public MerchantAccount createNewMerchant();
	
	public MerchantStatus getMerchantStatus(Merchant merchant);
	
	public void activateMerchant(Merchant merchant);
	
	public void deActivateMerchant(Merchant merchant);
	
	public void getReserveAmountForMerchant(Merchant merchant);
	
	public void getLedgerForMerchant(Merchant merchant);
	
	
}
