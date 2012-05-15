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

import com.own.controller.utils.ServiceUtils;
import com.own.merchant.MerchantManager;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.Merchant.SearchTypes;
import com.own.merchant.model.Merchant.ValidationType;
import com.own.merchant.model.MerchantRegistration;
import com.own.service.exception.AppException;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.MerchantValidationException;
import com.own.service.exception.ServiceException;

@Service
public class MerchantServiceImpl implements MerchantService {

	private static Logger logger = Logger.getLogger(MerchantServiceImpl.class);


	@Autowired
	MerchantManager merchantManager;

	@Autowired
	Validator validator;
	
	@Transactional
	public Merchant createMerchant(Merchant merchant)
			throws ServiceException {

		Merchant response = null;
		
		
		
		response = merchantManager.getMerchantByEmail(merchant.getEmailID());
		
		if (null != response) {
			logger.info("Throw new exception that the merchant already exists");
			throw new ServiceException("duplicate.value","merchant already exists");
		}
		
		String username = createMerchantUserName(merchant);
		
		merchant.setMerchantUsername(username);
		
		try {
			
			response = merchantManager.saveMerchant(merchant);
			
		} catch (IllegalObjectStateException e) {
			logger.info("The merchant object cannot be presisted");
			e.printStackTrace();
			throw new ServiceException(e.getErrorMessages()).addErrorCode("service.error", "Not able to take merchatn on-board");
		}
		
		return response;
	}

	private String createMerchantUserName(Merchant response) {
		
		return "test";
	}

	public Merchant updateMerchant(Merchant merchant) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	public Merchant deActivateMerchant(Merchant merchant) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	public Merchant activateMerchant(Merchant merchant) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	public Merchant activateMerchantAccount(Merchant merchant,
			List<String> accountID, boolean activateAll) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant getMerchantByID(String merchantID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant getMerchantByEmail(String merchantEmail) {
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
	public boolean authenticate(Merchant merchant)
			throws MerchantValidationException,IllegalObjectStateException {
		Map<String, String> response = new HashMap<String, String>();
		Set<ConstraintViolation<Merchant>> validate = validator.validate(merchant, ValidationType.LOGIN.getClazz());
		logger.info("Validate:" + validate);
		
		Merchant validMerchant = merchantManager.getMerchantByID(merchant
				.getMerchantUsername());

		if (null == validMerchant) {
			logger.info("no merchant found for the given username");

			response.put("ERROR", "no merchant found for the given username");

		}
		if (ServiceUtils.compareString(validMerchant.getPassword(),
				merchant.getPassword())) {
			logger.info("Merchant successfully authenticated:");
		} else {
			logger.info("No matching merchant found");
			response.put("ERROR", "No matching merchant found");
		}

		if (response.size() != 0) {
			throw new MerchantValidationException(response);
		}

		return true;
	}

	@Override
	public MerchantRegistration registerMerchant(MerchantRegistration rMerchant) {
		// TODO Auto-generated method stub
		return null;
	}

}
