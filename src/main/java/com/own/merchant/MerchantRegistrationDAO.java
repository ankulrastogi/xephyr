package com.own.merchant;

import com.own.merchant.model.MerchantRegistration;

public interface MerchantRegistrationDAO {

	public MerchantRegistration save(MerchantRegistration registration);

	public MerchantRegistration getRegistrationByEmail(String emailID);

	public MerchantRegistration update(MerchantRegistration rMerchant);
	
}