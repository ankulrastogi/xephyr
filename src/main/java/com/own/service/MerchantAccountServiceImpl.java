package com.own.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.own.common.constants.ErrorConstants;
import com.own.merchant.MerchantAccountManager;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.MerchantAccount;
import com.own.merchant.model.MerchantAccount.MerchantAccountStatus;
import com.own.service.exception.BaseException.ExceptionType;
import com.own.service.exception.DatabaseException;
import com.own.service.exception.ServiceException;

@Service
public class MerchantAccountServiceImpl implements MerchantAccountService {
	
	@Autowired
	MerchantAccountManager maManager;
	
	@Transactional
	public MerchantAccount createAccount(MerchantAccount account) {
		
		return null;
	}

	@Transactional
	@Override
	public MerchantAccount createAccountForMerchant(MerchantAccount mAccount,
			Merchant merchant) throws ServiceException {

		// check if the merchantAccount already exists
		try {
			MerchantAccount existing = maManager
					.findAccountByAccountName(mAccount.getName());
			if (null != existing) {
				throw new ServiceException(ExceptionType.VIEW,
						ErrorConstants.ACCOUNT_EXISTS, new Throwable());
			}

			mAccount.setMerchantUserID(merchant.getMerchantUserID());
			mAccount.setStatus(MerchantAccountStatus.PENDING);
			mAccount.setUniqueKey("account_" + mAccount.getName());
			
			mAccount = maManager.saveMerchantAccount(mAccount);
		} catch (DatabaseException e) {

			throw new ServiceException(e.getErrorMessages(), e);
		}

		return mAccount;

	}

}
