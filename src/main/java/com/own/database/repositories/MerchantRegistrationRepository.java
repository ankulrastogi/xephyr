package com.own.database.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.own.merchant.model.MerchantRegistration;

@Repository
public interface MerchantRegistrationRepository extends CrudRepository<MerchantRegistration, Integer>{

	@Transactional(readOnly=true)
	@Query("from MerchantRegistration mr where mr.email=:email")
	MerchantRegistration getByEmail(@Param("email")String emailID);

}
