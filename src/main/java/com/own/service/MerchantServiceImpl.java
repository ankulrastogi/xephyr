package com.own.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.own.database.dao.MerchantDAO;
import com.own.merchant.model.Merchant;
import com.own.service.exception.AppException;
import com.own.service.exception.DuplicateValueException;


@Service
public class MerchantServiceImpl implements MerchantService{

	@Autowired
	MerchantDAO merchantDao;
	
	@Transactional
	public Merchant createMerchant(Merchant merchant) throws DuplicateValueException {
		
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


}
