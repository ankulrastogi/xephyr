package com.own.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.own.merchant.RegistrationManager;
import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.MerchantRegistration.RegistrationStatus;
import com.own.merchant.model.MerchantRegistration.ValidationType;
import com.own.service.exception.DatabaseException;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.ServiceException;

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

		MerchantRegistration response=null;
		
		try {
			response = registrationManager
					.findByEmail(rMerchant.getEmail());
			if(null != response)
			{
				throw new ServiceException("11","User already exists",new Throwable());
				
			}
			String activationLink = generateActivationLink(rMerchant);
			rMerchant.setActivationLink(activationLink);
			rMerchant.setStatus(RegistrationStatus.PENDING);

			response = registrationManager.save(rMerchant);

			sendActivationLinkOnMail(rMerchant);

		} catch (IllegalObjectStateException e) {

			logger.info("the objects cannot be verified PRE or POST validation"
					+ e.getErrorMessages());

			throw new ServiceException(e.getErrorMessages(), e).addErrorCode(
					"validation.failed", "validation Failed for registration");
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getErrorMessages(), e).addErrorCode(
					"database.exception", "database exception");
		}

		logger.info(response);

		return response;

	}

	/**
	 * Sends the activation link by mail for the user to activate his account
	 * 
	 * @param rMerchant
	 */
	private void sendActivationLinkOnMail(MerchantRegistration rMerchant) {
		// TODO Auto-generated method stub

	}

	/**
	 * Generates activation Link for the merchant registration process.
	 * Temporary parked here
	 * 
	 * @param rMerchant
	 * @return
	 */
	private String generateActivationLink(MerchantRegistration rMerchant) {
		// TODO Auto-generated method stub
		return "activationLink";
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
	public MerchantRegistration getRegistrationByEmail(String emailID) throws ServiceException{
		// TODO Auto-generated method stub
		MerchantRegistration findByEmail = null;
		try {
			findByEmail = registrationManager.findByEmail(emailID);
		} catch (DatabaseException e) {
			logger.info("Failed to get merchant registration information:" + emailID + e.getMessage());
			throw new ServiceException(e.getErrorMessages(),e);
		}
		return findByEmail;
	}

	@Override
	public Map<String, String> validate(MerchantRegistration rMerchant,
			ValidationType signup) throws ServiceException {

		return null;
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
			throw new ServiceException(e1);
		}

		if (null == rMerchant) {
			throw new ServiceException("merchant.not.found",
					"no merchant pending activation by this email ID",
					new Throwable());
		}
		if (rMerchant.activationExpired()) {
			throw new ServiceException("activation.expired",
					"activationExpired", new Throwable());
		}
		if (rMerchant.consumed()) {
			throw new ServiceException("activation.used",
					"activation already used", new Throwable());
		}
		if (!rMerchant.getActivationLink().equals(identifier)) {
			throw new ServiceException("invalid.identifier",
					"invalid identifier", new Throwable());
		}

		rMerchant.setStatus(RegistrationStatus.ACTIVE);

		try {
			registrationManager.save(rMerchant);
		} catch (IllegalObjectStateException e) {

			throw new ServiceException(e.getErrorMessages(), e).addErrorCode(
					"ERROR", "failed to activate merchant");
		} catch (DatabaseException e) {

			throw new ServiceException(e.getErrorMessages(), e).addErrorCode(
					"ERROR", "failed to activate merchant");
		}
		return rMerchant;

	}

}
