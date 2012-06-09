package com.own.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.own.merchant.model.MerchantAccount;

public interface MerchantAccountRepository extends CrudRepository<MerchantAccount, Long>{
	
	@Transactional(readOnly=true)
	public MerchantAccount findByNameIgnoreCase(String accountName);

}
