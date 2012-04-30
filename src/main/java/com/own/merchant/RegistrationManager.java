package com.own.merchant;

import com.own.merchant.model.MerchantRegistration;
import com.own.service.exception.IllegalStateException;

public interface RegistrationManager {

	public MerchantRegistration save(MerchantRegistration rMerchant) throws IllegalStateException;
	
	public MerchantRegistration findByEmail(String emailID);
	
	public boolean checkRegistrationByEmail(String emailID);
	
}
