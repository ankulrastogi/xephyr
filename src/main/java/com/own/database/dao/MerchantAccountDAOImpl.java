package com.own.database.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.own.transaction.merchant.model.MerchantAccount;

public class MerchantAccountDAOImpl implements MerchantAccountDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public MerchantAccount save(MerchantAccount account) {
		// TODO Auto-generated method stub
		return (MerchantAccount)sessionFactory.getCurrentSession().save(account);
	}

}
