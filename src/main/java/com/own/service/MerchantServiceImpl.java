package com.own.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.own.merchant.MerchantManager;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.Merchant.SearchTypes;
import com.own.merchant.model.Merchant.ValidationType;
import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.MerchantRegistration.RegistrationStatus;
import com.own.service.exception.AppException;
import com.own.service.exception.DatabaseException;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.MerchantValidationException;
import com.own.service.exception.ServiceException;
import com.own.transaction.enums.MerchantStatus;

@Service
public class MerchantServiceImpl implements MerchantService {

	private static Logger logger = Logger.getLogger(MerchantServiceImpl.class);

	@Autowired
	MerchantManager merchantManager;

	@Autowired
	MerchantRegistrationService merchantRegistrationService;

	@Autowired
	Validator validator;

	public Merchant createMerchant(Merchant merchant) throws ServiceException {

		Merchant response = null;

		String username = getMerhantID(merchant);

		merchant.setMerchantUsername(username);

		try {
			response = merchantManager
					.getMerchantByEmail(merchant.getEmailID());

			if (null != response) {
				logger.info("Throw new exception that the merchant already exists");
				throw new ServiceException("duplicate.value",
						"merchant already exists", new Throwable());
			}

			response = merchantManager.saveMerchant(merchant);

		} catch (IllegalObjectStateException e) {
			logger.info("The merchant object cannot be presisted.Object state is not valid:"
					+ e.getMessage());

			throw new ServiceException(e.getErrorMessages(), e).addErrorCode(
					"service.error", "Not able to take merchatn on-board");
		} catch (DatabaseException e) {
			logger.info("The merchant object cannot be presisted");
			throw new ServiceException(e.getErrorMessages(), e);
		}

		return response;
	}

	@Transactional(rollbackFor={ServiceException.class})
	public Merchant updateMerchant(Merchant merchant) throws ServiceException {
		
		
		
		return null;
	}

	private Merchant getMerchantByID(String merchantID) throws ServiceException
	{
		Merchant result = null;
		try
		{
			result = merchantManager.getMerchantByID(merchantID);
		}catch (DatabaseException e) {
			throw new ServiceException(e.getErrorMessages(),e);
		} catch (IllegalObjectStateException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getErrorMessages(),e);
		}
		if(null == result)
		{
			throw new ServiceException("11","Cannot get merchant by ID",new Throwable());
		}
		
		return result;
	}
	
	@Transactional(rollbackFor={ServiceException.class})
	public Merchant deActivateMerchant(String merchantID) throws ServiceException {
		return updateMerchantStatus(MerchantStatus.ACTIVE, merchantID);
	}

	@Transactional(rollbackFor={ServiceException.class})
	public Merchant activateMerchant(String merchantID) throws ServiceException {
		return updateMerchantStatus(MerchantStatus.ACTIVE, merchantID);
	}
	
	private Merchant updateMerchantStatus(MerchantStatus status,String merchantID)throws ServiceException
	{
		Merchant merchant = getMerchantByID(merchantID);
		try
		{
			merchant.setStatus(status);
			merchant = merchantManager.saveMerchant(merchant);
		}catch (DatabaseException e) {
		
			throw new ServiceException(e.getErrorMessages(),e);
		} catch (IllegalObjectStateException e) {
			
			throw new ServiceException(e.getErrorMessages(),e);
		}
		
		return merchant;
	}

	public Merchant activateMerchantAccount(Merchant merchant,
			List<String> accountID, boolean activateAll) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Merchant> findMerchant(Map<SearchTypes, String> searchParamMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant getMerchantInfo(Merchant merchant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant loginUser(Merchant merchant)
			throws MerchantValidationException, ServiceException {
		Map<String, String> response = new HashMap<String, String>();
		Set<ConstraintViolation<Merchant>> validate = validator.validate(
				merchant, ValidationType.LOGIN.getClazz());
		logger.info("Validate:" + validate);

		Merchant validMerchant = null;
		try {

			validMerchant = merchantManager.getMerchantByEmail(merchant
					.getEmailID());
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getErrorMessages(), e);
		}

		if (null == validMerchant) {
			logger.info("no merchant found for the given username");

			throw new ServiceException("ERROR",
					"no merchant found for the given username", new Throwable());

		}
		if (validMerchant.getPassword().equals(merchant.getPassword())) {
			logger.info("Merchant successfully authenticated:");
		} else {
			logger.info("No matching merchant found");
			response.put("ERROR", "Merchant password do not match");
		}

		if (response.size() != 0) {
			throw new ServiceException(response, new Throwable());
		}

		return validMerchant;
	}

	@Override
	public MerchantRegistration registerMerchant(MerchantRegistration rMerchant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant moveMerchantOnBoard(String emailID) throws ServiceException {

		MerchantRegistration registrationByEmail = merchantRegistrationService
				.getRegistrationByEmail(emailID);

		if (null == registrationByEmail)
			throw new ServiceException("11",
					"No registration for the given email.Cannot onboard",
					new Throwable());

		if (registrationByEmail.getStatus() != RegistrationStatus.ACTIVE)
			throw new ServiceException(
					"12",
					"The registration is yet not on active status. Cannot onboard",
					new Throwable());

		Merchant merchant = new Merchant();
		merchant.setEmailID(registrationByEmail.getEmail());
		merchant.setName(registrationByEmail.getName());
		merchant.setPassword(registrationByEmail.getPassword());
		merchant.setStatus(MerchantStatus.ACTIVE);
		return createMerchant(merchant);
	}

	/**
	 * Generates a unique key for the merchant which will be shared by the account for authentication and audit purpose
	 * @param merchant
	 */
	private String getMerhantID(Merchant merchant) {
		return "test_" + merchant.getEmailID();
		
	}

}
