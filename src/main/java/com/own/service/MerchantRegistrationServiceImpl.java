package com.own.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.own.merchant.RegistrationManager;
import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.MerchantRegistration.ValidationType;
import com.own.service.exception.IllegalStateException;
import com.own.service.exception.ServiceException;
@Service
public class MerchantRegistrationServiceImpl implements
		MerchantRegistrationService{

	private static Logger logger = Logger.getLogger(MerchantRegistrationServiceImpl.class);
	
	@Autowired
	RegistrationManager registrationManager;
	
	@Override
	@Transactional
	public MerchantRegistration registerMerchant(
			MerchantRegistration rMerchant)throws ServiceException {
		
		MerchantRegistration response = registrationManager.findByEmail(rMerchant.getEmail());
		if (null != response) {
			
			logger.info("Throw new exception that the merchant already exists");
			
			throw new ServiceException("code","message");
		}
		
		try
		{
			response = registrationManager.save(rMerchant);
			
		}catch (IllegalStateException e) {
		
			
			logger.info("the objects cannot be verified PRE or POST validation");
			throw new ServiceException("code","message");
		}
		
		
		logger.info(response);
		
		
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

	@Override
	public Map<String, String> validate(MerchantRegistration rMerchant,
			ValidationType signup) throws ServiceException {
		
		return null;
	}

}
