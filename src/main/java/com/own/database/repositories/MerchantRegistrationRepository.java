package com.own.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.own.merchant.model.MerchantRegistration;

@Repository
public interface MerchantRegistrationRepository extends CrudRepository<MerchantRegistration, Integer>{

	@Transactional(readOnly=true)
	MerchantRegistration findByEmail(String emailID);

}
