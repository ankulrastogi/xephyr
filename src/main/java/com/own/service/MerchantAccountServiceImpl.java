package com.own.service;

import org.apache.commons.lang3.StringUtils;
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
import com.own.service.exception.IllegalObjectStateException;
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

	@Transactional
	@Override
	public MerchantAccount activateAcccount(MerchantAccount mAccount)
			throws ServiceException {

		try {
			MerchantAccount current = maManager
					.findAccountByAccountName(mAccount.getName());
			if (null == current) {
				throw new ServiceException(ExceptionType.VIEW,
						ErrorConstants.MERCHANT_ACCOUNT_NOT_FOUND, "",
						new Throwable());
			}
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Transactional(rollbackFor = ServiceException.class)
	@Override
	public MerchantAccount updateMerchantAccount(MerchantAccount mAccount)
			throws ServiceException, IllegalObjectStateException {
		// check if there is another account with the same name
		if (checkDuplicateName(mAccount.getName()))
			throw new IllegalObjectStateException(ExceptionType.VIEW,
					ErrorConstants.ACCOUNT_NAME_EXISTS, new Throwable());
		MerchantAccount saveMerchantAccount = null;
		try {
			saveMerchantAccount = maManager.saveMerchantAccount(mAccount);
		} catch (DatabaseException e) {
			throw new ServiceException(e.getErrorMessages(), e);

		}
		return saveMerchantAccount;

	}

	private boolean checkDuplicateName(String name) {
		if (StringUtils.isBlank(name))
			return false;
		try {
			MerchantAccount findAccountByAccountName = maManager
					.findAccountByAccountName(name);
			if (null != findAccountByAccountName)
				return true;
			else
				return false;
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	@Override
	@Transactional(rollbackFor=ServiceException.class)
	public void removeAccount(MerchantAccount mAccount) throws ServiceException {
		
		mAccount.setStatus(MerchantAccountStatus.INACTIVE);
		try {
			maManager.saveMerchantAccount(mAccount);
		} catch (DatabaseException e) {
			throw new ServiceException(e.getErrorMessages(),e);
		}
	}

}
