package com.own.merchant;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.own.common.constants.ErrorConstants;
import com.own.database.repositories.MerchantAccountRepository;
import com.own.merchant.model.MerchantAccount;
import com.own.service.exception.BaseException.ExceptionType;
import com.own.service.exception.DatabaseException;
import com.own.transaction.enums.MerchantAccountStatus;

@Component
public class MerchantAccountManagerImpl implements MerchantAccountManager{

	private static Logger logger = Logger.getLogger(MerchantAccountManagerImpl.class);
	
	@Autowired
	MerchantAccountRepository maRepository;
	@Override
	public MerchantAccount findAccountByAccountName(String name)
			throws DatabaseException {

		MerchantAccount mAccount = null;
		try {
			mAccount = maRepository.findByNameIgnoreCase(name);
		} catch (Exception e) {
			logger.info("Could not get merchant account info from the database:"
					+ name + e.getMessage());
			throw new DatabaseException(ExceptionType.LOG,
					ErrorConstants.DATABASE_ERROR, e);

		}

		return mAccount;
	}

	@Override
	public MerchantAccount saveMerchantAccount(MerchantAccount mAccount)
			throws DatabaseException {

		try {
			mAccount = maRepository.save(mAccount);
		} catch (Exception e) {
			logger.info("Could not get merchant account info from the database:"
					+ mAccount + e.getMessage());
			throw new DatabaseException(ExceptionType.LOG,
					ErrorConstants.DATABASE_ERROR, e);

		}

		return mAccount;
	}

	@Override
	public MerchantAccount getMerchantAccountByID(String merchantID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMerchantAccountDetails(MerchantAccount account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MerchantAccount createNewMerchantAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantAccountStatus getMerchantAccountStatus(
			MerchantAccount account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void activateMerchantAccount(MerchantAccount account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deActivateMerchantAccount(MerchantAccount account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReserveAmountForMerchantAccount(MerchantAccount account) {
		// TODO Auto-generated method stub
		
	}

}
