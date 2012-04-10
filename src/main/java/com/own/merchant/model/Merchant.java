package com.own.merchant.model;

import java.util.List;

import com.own.transaction.enums.MerchantStatus;
import com.own.transaction.merchant.model.MerchantAccount;

/**
 * This is a class containing the details related to a merchant object
 * @author ankul
 *
 */
public class Merchant {

	private String merchantName;
	
	private List<MerchantAccount> accounts;
	
	private MerchantStatus status;
	
	private MerchantDetails details;
	
	private String configuration;
	


	

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public List<MerchantAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<MerchantAccount> accounts) {
		this.accounts = accounts;
	}

	public MerchantStatus getStatus() {
		return status;
	}

	public void setStatus(MerchantStatus status) {
		this.status = status;
	}

	public MerchantDetails getDetails() {
		return details;
	}

	public void setDetails(MerchantDetails details) {
		this.details = details;
	}

	public String getConfiguration() {
		return configuration;
	}

	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	
	
}
