package com.own.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.own.common.constants.ErrorConstants;
import com.own.merchant.MerchantManager;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.Merchant.SearchTypes;
import com.own.merchant.model.Merchant.ValidationType;
import com.own.merchant.model.MerchantRegistration;
import com.own.merchant.model.MerchantRegistration.RegistrationStatus;
import com.own.service.exception.BaseException.ExceptionType;
import com.own.service.exception.DatabaseException;
import com.own.service.exception.IllegalObjectStateException;
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

		String username = generateMerchantUserID(merchant);

		merchant.setMerchantUserID(username);

		try {
			response = merchantManager
					.getMerchantByEmail(merchant.getEmailID());

			if (null != response) {
				logger.info("Throw new exception that the merchant already exists");
				throw new ServiceException(ExceptionType.VIEW,ErrorConstants.DUPLICATE_MERCHANT,
						 new Throwable());
			}
			response = merchantManager.saveMerchant(merchant);

		} catch (IllegalObjectStateException e) {
			logger.info("The merchant object cannot be presisted.Object state is not valid:"
					+ e.getMessage());

			throw new ServiceException(e.getErrorMessages(), e);
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
			throw new ServiceException(ExceptionType.LOG,ErrorConstants.MERCHANT_NOT_FOUND_EMAIL,new Throwable());
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
			List<String> accountID, boolean activateAll) throws ServiceException {
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
			throws  ServiceException {
		Map<Integer, List<Object>> response = new HashMap<Integer, List<Object>>();
		
	
		Merchant validMerchant = null;
		try {
			merchant.validate(ValidationType.LOGIN);
			validMerchant = merchantManager.getMerchantByEmail(merchant
					.getEmailID());
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getErrorMessages(), e);
		} catch (IllegalObjectStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getErrorMessages(), e);
		}

		if (null == validMerchant) {
			logger.info("no merchant found for the given username");

			throw new ServiceException(ExceptionType.VIEW,ErrorConstants.MERCHANT_NOT_FOUND_EMAIL_USERNAME,
					 new Throwable());

		}
		if (validMerchant.getPassword().equals(merchant.getPassword())) {
			logger.info("Merchant successfully authenticated:");
		} else {
			logger.info("Merchant Authentication failed");
			response.put(ErrorConstants.AUTHENTICATION_FAILED, new ArrayList<Object>());
		}

		if (response.size() != 0) {
			throw new ServiceException(ExceptionType.VIEW,response, new Throwable());
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
			throw new ServiceException(ExceptionType.VIEW,
					ErrorConstants.MERCHANT_NOT_FOUND_EMAIL,
					new Throwable());

		if (registrationByEmail.getStatus() != RegistrationStatus.ACTIVE)
			throw new ServiceException(
					ExceptionType.VIEW,
					ErrorConstants.REGISTRATION_NOT_ACTIVE,
					new Throwable());

		Merchant merchant = new Merchant();
		merchant.setEmailID(registrationByEmail.getEmail());
		merchant.setName(registrationByEmail.getFirstName()+registrationByEmail.getLastName());
		merchant.setPassword(registrationByEmail.getPassword());
		merchant.setStatus(MerchantStatus.ACTIVE);
		return createMerchant(merchant);
	}

	/**
	 * Generates a unique key for the merchant which will be shared by the account for authentication and audit purpose
	 * @param merchant
	 */
	private String generateMerchantUserID(Merchant merchant) {
		return "test_" + merchantManager.getCount();
		
	}

}
