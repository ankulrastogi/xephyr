package com.own.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.own.controller.utils.ServiceUtils;
import com.own.database.dao.MerchantDAO;
import com.own.merchant.MerchantManager;
import com.own.merchant.manager.MerchantValidator;
import com.own.merchant.manager.MerchantValidatorImpl.ValidationType;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.Merchant.SearchTypes;
import com.own.service.exception.AppException;
import com.own.service.exception.DuplicateValueException;
import com.own.service.exception.MerchantValidationException;

@Service
public class MerchantServiceImpl implements MerchantService {

	private static Logger logger = Logger.getLogger(MerchantServiceImpl.class);

	@Autowired
	MerchantDAO merchantDao;

	@Autowired
	MerchantManager manager;

	@Autowired
	MerchantValidator validator;

	@Transactional
	public Merchant createMerchant(Merchant merchant, ValidationType type)
			throws DuplicateValueException {

		manager.isValidMerchant(merchant, ValidationType.PRE);

		if (!manager.checkMerchantByEmail(merchant.getEmailID())) {
			merchant = manager.saveMerchant(merchant);
		}
		return merchantDao.save(merchant);
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
			throws MerchantValidationException {
		Map<String, String> response = new HashMap<String, String>();
		response = validator.validateMerchant(merchant, ValidationType.LOGIN);
		if (response.size() != 0) {
			throw new MerchantValidationException(response);
		}

		Merchant validMerchant = manager.getMerchantByID(merchant
				.getMerchantID());

		if (null == validMerchant) {
			logger.info("no merchant found for the given username");

			response.put("ERROR", "no merchant found for the given username");

		}
		if (ServiceUtils.compareString(validMerchant.getMerchantID(),
				merchant.getMerchantID())) {
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

}
