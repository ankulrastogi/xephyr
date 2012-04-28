package com.own.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.own.merchant.model.MerchantRegistration;

@Component
public class RegistrationManagerImpl implements RegistrationManager{

	@Autowired
	MerchantRegistrationDAO merchantRegistrationDAO;
	
	@Override
	public MerchantRegistration save(MerchantRegistration rMerchant) {
		
		return merchantRegistrationDAO.save(rMerchant);
	}

	@Override
	public MerchantRegistration findByEmail(String emailID) {
		
		return merchantRegistrationDAO.getRegistrationByEmail(emailID);
	}

	@Override
	public boolean checkRegistrationByEmail(String emailID) {
		
		MerchantRegistration response = merchantRegistrationDAO.getRegistrationByEmail(emailID);
		if(null == response)
			return false;
		
		return true;
	}

}
