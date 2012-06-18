package com.own.merchant;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.own.database.repositories.MerchantRegistrationRepository;
import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.MerchantRegistration.ValidationType;
import com.own.service.exception.DatabaseException;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.BaseException.ExceptionType;
import com.pg.common.constant.MessageCodeConstant;

@Component
public class RegistrationManagerImpl implements RegistrationManager {

	private static Logger logger = Logger
			.getLogger(RegistrationManagerImpl.class);

	@Autowired
	MerchantRegistrationRepository merchantRegistrationRepository;

	@Override
	public MerchantRegistration save(MerchantRegistration rMerchant)
			throws IllegalObjectStateException, DatabaseException {
		rMerchant.validate(ValidationType.PRE);

		MerchantRegistration result = new MerchantRegistration();
		try {
			result = merchantRegistrationRepository.save(rMerchant);
		} catch (Exception e) {
			logger.info("Cannot persist user object in data:" + rMerchant
					+ e.getMessage());
			throw new DatabaseException(ExceptionType.VIEW,MessageCodeConstant.DATABASE_ERROR,e);
		}
		logger.info("saved:" + result);
		
		result.validate(ValidationType.POST);
		return result;
	}

	@Override
	public MerchantRegistration findByEmail(String emailID)
			throws DatabaseException {

		MerchantRegistration rMerchant = null;
		try {
			rMerchant = merchantRegistrationRepository.findByEmail(emailID);
		} catch (Exception e) {

			logger.info("ERROR in getting info for email:" + emailID
					+ e.getMessage());
			throw new DatabaseException(ExceptionType.VIEW,MessageCodeConstant.DATABASE_ERROR,e);
		}
		return rMerchant;
	}

	@Override
	public boolean checkRegistrationByEmail(String emailID) {

		MerchantRegistration response = merchantRegistrationRepository
				.findByEmail(emailID);
		if (null == response)
			return false;

		return true;
	}

	@Override
	@Transactional(rollbackFor = IllegalObjectStateException.class)
	public MerchantRegistration update(MerchantRegistration rMerchant)
			throws IllegalObjectStateException {
		rMerchant.validate(ValidationType.PRE);

		MerchantRegistration result = merchantRegistrationRepository
				.findOne(rMerchant.getSignUpID());
		result.setEmail(rMerchant.getEmail());
		result.setFirstName(rMerchant.getFirstName());
		result.setLastName(rMerchant.getLastName());
		result.setStatus(rMerchant.getStatus());
		
		result.validate(ValidationType.POST);
		return result;
	}

}
