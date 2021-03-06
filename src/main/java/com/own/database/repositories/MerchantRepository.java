package com.own.database.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.own.merchant.model.Merchant;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Long>{

	@Transactional(readOnly=true)
	@Query("from Merchant m where m.merchantUserID = :userID")
	Merchant findbyUserID(@Param("userID")String userID);
		
	Merchant findByEmailID(String emailID);

}
