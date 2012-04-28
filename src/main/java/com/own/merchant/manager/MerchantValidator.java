package com.own.merchant.manager;

import java.util.Map;

import com.own.merchant.manager.MerchantValidatorImpl.ValidationType;
import com.own.merchant.model.Merchant;

public interface MerchantValidator {

	public void setValidationType(ValidationType type);
	
	public boolean isValidMerchant(Merchant merchant,ValidationType type);
	
	public Map<String,String> validateMerchant(Merchant merchant,ValidationType type);
}
