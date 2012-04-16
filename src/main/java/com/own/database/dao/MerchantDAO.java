package com.own.database.dao;

import java.util.List;

import com.own.merchant.model.Merchant;

public interface MerchantDAO {

	public Merchant save(Merchant merchant);
	
	public Merchant getMerchantByID(int merchantID);
	
	public List<Merchant> getAllMerchants();
	
	
}
