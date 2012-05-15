package com.own.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.own.database.repositories.MerchantRepository;
import com.own.merchant.model.Merchant;
import com.own.merchant.model.Merchant.ValidationType;
import com.own.service.exception.IllegalObjectStateException;
import com.own.transaction.enums.MerchantStatus;
import com.own.transaction.merchant.model.MerchantAccount;

@Component
public class MerchantManagerImpl implements MerchantManager {

	@Autowired
	MerchantRepository merchantRepository;
	
	@Override
	public Merchant getMerchantByID(String username) {
		// TODO Auto-generated method stub
		return merchantRepository.finbyUserID(username);
	}

	@Override
	public boolean checkMerchantByEmail(String mEmailID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Merchant saveMerchant(Merchant merchant) throws IllegalObjectStateException{
		merchant.validate(ValidationType.PRE);
		Merchant result = merchantRepository.save(merchant);
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
	public Merchant getMerchantByEmail(String emailID) {
		// TODO Auto-generated method stub
		return null;
	}

}
