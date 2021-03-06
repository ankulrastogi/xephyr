package com.own.service;

import java.util.Calendar;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.own.merchant.RegistrationManager;
import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.MerchantRegistration.RegistrationStatus;
import com.own.merchant.model.MerchantRegistration.ValidationType;
import com.own.service.exception.BaseException.ExceptionType;
import com.own.service.exception.DatabaseException;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.ServiceException;
import com.pg.common.constant.MessageCodeConstant;

@Service
public class MerchantRegistrationServiceImpl implements
		MerchantRegistrationService {

	private static Logger logger = Logger
			.getLogger(MerchantRegistrationServiceImpl.class);

	@Autowired
	RegistrationManager registrationManager;

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public MerchantRegistration registerMerchant(MerchantRegistration rMerchant)
			throws ServiceException {

		MerchantRegistration response = null;

		try {
			response = registrationManager.findByEmail(rMerchant.getEmail());
			if (null != response) {
				throw new ServiceException(ExceptionType.VIEW,
						MessageCodeConstant.USER_ALREADY_EXISTS, new Throwable());

			}

			rMerchant.setActivationLink("activationLink");
			rMerchant.setStatus(RegistrationStatus.PENDING);
			rMerchant.setCreationDate(Calendar.getInstance().getTime());
			rMerchant.setUpdationDate(Calendar.getInstance().getTime());

			response = registrationManager.save(rMerchant);

		} catch (IllegalObjectStateException e) {

			logger.info("the objects cannot be verified PRE or POST validation"
					+ e.getErrorMessages());

			throw new ServiceException(e.getErrorMessages(), e).addErrorCode(
					ExceptionType.LOG, MessageCodeConstant.LOG,
					"verification Exception");
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getErrorMessages(), e)
					.addErrorCode(ExceptionType.LOG, MessageCodeConstant.LOG,
							"database exception");
		}

		logger.info(response);

		return response;

	}

	@Override
	public boolean checkRegistrationByEmail(MerchantRegistration rMerchant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MerchantRegistration saveRegistration(MerchantRegistration rMerchant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantRegistration getRegistrationByEmail(String emailID)
			throws ServiceException {
		// TODO Auto-generated method stub
		MerchantRegistration findByEmail = null;
		try {
			findByEmail = registrationManager.findByEmail(emailID);
		} catch (DatabaseException e) {
			logger.info("Failed to get merchant registration information:"
					+ emailID + e.getMessage());
			throw new ServiceException(e.getErrorMessages(), e);
		}
		return findByEmail;
	}

	@Override
	public Map<String, String> validate(MerchantRegistration rMerchant,
			ValidationType signup) throws ServiceException {

		return null;
	}

	
	@Override
	public MerchantRegistration activateRegistration(MerchantRegistration newMerchant) throws ServiceException
	{
		return activateRegistration(newMerchant.getEmail(),newMerchant.getActivationLink());
				
	}
	@Override
	public MerchantRegistration activateRegistration(String emailID,
			String identifier) throws ServiceException {

		MerchantRegistration rMerchant = null;
		try {
			rMerchant = registrationManager.findByEmail(emailID);
		} catch (DatabaseException e1) {
			// TODO Auto-generated catch block
			logger.info("Exception:" + e1.getMessage());
			throw new ServiceException(e1.getErrorMessages(), e1);
		}

		if (null == rMerchant) {
			throw new ServiceException(ExceptionType.VIEW,
					MessageCodeConstant.MERCHANT_NOT_FOUND_EMAIL, new Throwable());
		}
		if (rMerchant.activationExpired()) {
			throw new ServiceException(ExceptionType.VIEW,
					MessageCodeConstant.ACTIVATION_EXPIRED, new Throwable());
		}
		if (rMerchant.consumed()) {
			throw new ServiceException(ExceptionType.VIEW,
					MessageCodeConstant.ACTIVATION_USED, new Throwable());
		}
		if (!rMerchant.getActivationLink().equals(identifier)) {
			throw new ServiceException(ExceptionType.VIEW,
					MessageCodeConstant.INVALID_ACTIVATION_LINK, new Throwable());
		}

		rMerchant.setStatus(RegistrationStatus.ACTIVE);
		rMerchant.setUpdationDate(Calendar.getInstance().getTime());

		try {
			registrationManager.save(rMerchant);
		} catch (IllegalObjectStateException e) {

			throw new ServiceException(e.getErrorMessages(), e).addErrorCode(
					ExceptionType.LOG, MessageCodeConstant.ERROR, e);
		} catch (DatabaseException e) {
			throw new ServiceException(e.getErrorMessages(), e).addErrorCode(
					ExceptionType.LOG, MessageCodeConstant.ERROR, e);
		}
		return rMerchant;

	}

	@Override
	public void sendActivationLink(MerchantRegistration rMerchant) {
			
		
	}

}
