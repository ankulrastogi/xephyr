package com.own.merchant.model.view.form;

import com.own.merchant.model.MerchantAccount;

public class AddAccountForm {

	private String merchantID;

	private String accountName;
	
	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public MerchantAccount buildMerchantAccount() {
		MerchantAccount account = new MerchantAccount();
		account.setName(this.accountName);
		account.setMerchantUserID(this.merchantID);
		return account;
	}
	
}
