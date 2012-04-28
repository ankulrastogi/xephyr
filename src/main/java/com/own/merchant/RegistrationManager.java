package com.own.merchant;

import com.own.merchant.model.MerchantRegistration;

public interface RegistrationManager {

	public MerchantRegistration save(MerchantRegistration rMerchant);
	
	public MerchantRegistration findByEmail(String emailID);
	
	public boolean checkRegistrationByEmail(String emailID);
	
}
