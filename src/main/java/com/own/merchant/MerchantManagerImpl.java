package com.own.merchant;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.own.common.constants.ErrorConstants;
import com.own.database.repositories.MerchantAccountRepository;
import com.own.database.repositories.MerchantRepository;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.MerchantAccount;
import com.own.merchant.model.Merchant.ValidationType;
import com.own.service.exception.DatabaseException;
import com.own.service.exception.IllegalObjectStateException;
import com.own.service.exception.BaseException.ExceptionType;
import com.own.transaction.enums.MerchantStatus;

@Component
public class MerchantManagerImpl implements MerchantManager {

	private static Logger logger = Logger.getLogger(MerchantManagerImpl.class);

	@Autowired
	MerchantRepository merchantRepository;

	@Autowired
	MerchantAccountRepository mAccountRepository;

	@Override
	public Merchant getMerchantByID(String merchantID) throws DatabaseException {
		// TODO Auto-generated method stub
		Merchant findOne = null;
		try {
			findOne = merchantRepository.findbyUserID(merchantID);
		} catch (Exception e) {
			logger.info("cannot get info from the database:" + e.getMessage());
			throw new DatabaseException(ExceptionType.LOG,
					ErrorConstants.DATABASE_ERROR, e);
		}

		return findOne;
	}

	@Override
	public boolean checkMerchantByEmail(String mEmailID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Merchant saveMerchant(Merchant merchant)
			throws IllegalObjectStateException, DatabaseException {
		merchant.validate(ValidationType.PRE);
		Merchant result = null;
		try {
			result = merchantRepository.save(merchant);
		} catch (Exception e) {
			logger.info("Error in saving merchant data:" + merchant
					+ e.getMessage());
			throw new DatabaseException(ExceptionType.LOG,
					ErrorConstants.DATABASE_ERROR, e);
		}

		result.validate(ValidationType.POST);
		return result;
	}

	@Override
	public void saveMerchantDetails(Merchant merchant) {
		// TODO Auto-generated method stub

	}

	@Override
	public MerchantAccount createNewMerchantAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantStatus getMerchantStatus(Merchant merchant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void activateMerchant(Merchant merchant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deActivateMerchant(Merchant merchant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getReserveAmountForMerchant(Merchant merchant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getLedgerForMerchant(Merchant merchant) {
		// TODO Auto-generated method stub

	}

	@Override
	public Merchant getMerchantByEmail(String emailID) throws DatabaseException {
		Merchant merchant = null;
		try {
			merchant = merchantRepository.findByEmailID(emailID);
		} catch (Exception e) {
			logger.info("Could not get merchant info from the database:"
					+ emailID + e.getMessage());
			throw new DatabaseException(ExceptionType.LOG,
					ErrorConstants.DATABASE_ERROR, e);

		}

		return merchant;
	}

	@Override
	public long getCount() {
		return merchantRepository.count();
	}


}
