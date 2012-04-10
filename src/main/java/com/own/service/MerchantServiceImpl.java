package com.own.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.own.merchant.model.Merchant;
import com.own.service.exception.AppException;
import com.own.service.exception.DuplicateValue;


@Service
public class MerchantServiceImpl implements MerchantService{

	public Merchant createMerchant(Merchant merchant) throws DuplicateValue {
		// TODO Auto-generated method stub
		return null;
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


}
