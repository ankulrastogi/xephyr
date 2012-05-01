package com.own.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.MerchantRegistration.ValidationType;
import com.own.service.exception.IllegalObjectStateException;

@Component
public class RegistrationManagerImpl implements RegistrationManager{

	@Autowired	
	MerchantRegistrationDAO merchantRegistrationDAO;
	
	@Override
	public MerchantRegistration save(MerchantRegistration rMerchant) throws IllegalObjectStateException {
		rMerchant.validate(ValidationType.PRE);
		MerchantRegistration result = merchantRegistrationDAO.save(rMerchant);
		result.validate(ValidationType.POST);
		return result;
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

	@Override
	public MerchantRegistration update(MerchantRegistration rMerchant)throws IllegalObjectStateException {
		rMerchant.validate(ValidationType.PRE);
		MerchantRegistration result = merchantRegistrationDAO.update(rMerchant);
		result.validate(ValidationType.POST);
		return result;
	}

}
