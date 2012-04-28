package com.own.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.own.database.dao.MerchantDAO;
import com.own.merchant.manager.MerchantValidatorImpl.ValidationType;
import com.own.merchant.model.Merchant;
import com.own.service.exception.MerchantException;
import com.own.transaction.enums.MerchantStatus;
import com.own.transaction.merchant.model.MerchantAccount;

@Component
public class MerchantManagerImpl implements MerchantManager {

	@Autowired
	MerchantDAO merchantDao;
	
	@Override
	public Merchant getMerchantByID(String merchantID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkMerchantByEmail(String mEmailID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Merchant saveMerchant(Merchant merchant) {
		// TODO Auto-generated method stub
		return null;
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
	public boolean validateMerchant(Merchant merchant, ValidationType type) throws MerchantException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Merchant getMerchantByEmail(String emailID) {
		// TODO Auto-generated method stub
		return null;
	}

}
