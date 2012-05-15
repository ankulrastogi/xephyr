package com.own.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.own.database.repositories.MerchantRegistrationRepository;
import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.MerchantRegistration.ValidationType;
import com.own.service.exception.IllegalObjectStateException;

@Component
public class RegistrationManagerImpl implements RegistrationManager{

	@Autowired	
	MerchantRegistrationRepository merchantRegistrationRepository;
	
	@Override
	public MerchantRegistration save(MerchantRegistration rMerchant) throws IllegalObjectStateException {
		rMerchant.validate(ValidationType.PRE);
		MerchantRegistration result = merchantRegistrationRepository.save(rMerchant);
		result.validate(ValidationType.POST);
		return result;
	}

	@Override
	public MerchantRegistration findByEmail(String emailID) {
		
		return merchantRegistrationRepository.getByEmail(emailID);
	}

	@Override
	public boolean checkRegistrationByEmail(String emailID) {
		
		MerchantRegistration response = merchantRegistrationRepository.getByEmail(emailID);
		if(null == response)
			return false;
		
		return true;
	}

	@Override
	@Transactional(rollbackFor=IllegalObjectStateException.class)
	public MerchantRegistration update(MerchantRegistration rMerchant)throws IllegalObjectStateException {
		rMerchant.validate(ValidationType.PRE);
		
		MerchantRegistration result = merchantRegistrationRepository.findOne(rMerchant.getSignUpID());
		result.setEmail(rMerchant.getEmail());
		result.setName(rMerchant.getName());
		result.validate(ValidationType.POST);
		return result;
	}

}
