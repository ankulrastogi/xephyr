package com.own.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.own.merchant.RegistrationManager;
import com.own.merchant.model.MerchantRegistration;
import com.own.service.exception.DuplicateValueException;
import com.own.service.exception.MerchantException;
@Service
public class MerchantRegistrationServiceImpl implements
		MerchantRegistrationService{

	private static Logger logger = Logger.getLogger(MerchantRegistrationServiceImpl.class);
	
	@Autowired
	RegistrationManager registrationManager;
	
	@Override
	@Transactional
	public MerchantRegistration registerMerchant(
			MerchantRegistration rMerchant)throws DuplicateValueException,MerchantException {
		
		MerchantRegistration response = null;
		
		//TODO find a way for validation
		//merchantManager.validateMerchant(merchant, ValidationType.PRE);
		
		if (registrationManager.checkRegistrationByEmail(rMerchant.getEmail())) {
			response = registrationManager.findByEmail(rMerchant.getEmail());
			logger.info("Throw new exception that the merchant already exists");
		}
		
		response = registrationManager.save(rMerchant);
		
		logger.info(response);
		
		//TODO find a way for validation
		//merchantManager.validateMerchant(merchant, ValidationType.POST);
		
		
		return response;
		
	}

	@Override
	public boolean checkRegistrationByEmail(
			MerchantRegistration rMerchant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MerchantRegistration saveRegistration(
			MerchantRegistration rMerchant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantRegistration getRegistrationByEmail(String emailID) {
		// TODO Auto-generated method stub
		return null;
	}

}
