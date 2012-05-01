package com.own.merchant;

import com.own.merchant.model.MerchantRegistration;
import com.own.service.exception.IllegalObjectStateException;

public interface RegistrationManager {

	public MerchantRegistration save(MerchantRegistration rMerchant) throws IllegalObjectStateException;
	
	public MerchantRegistration findByEmail(String emailID);
	
	public boolean checkRegistrationByEmail(String emailID);

	public MerchantRegistration update(MerchantRegistration rMerchant) throws IllegalObjectStateException;
	
}
