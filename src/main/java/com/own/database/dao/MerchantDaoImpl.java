package com.own.database.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.own.merchant.model.Merchant;

@Repository
public class MerchantDaoImpl  implements MerchantDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Merchant save(Merchant merchant) {
		this.sessionFactory.getCurrentSession().save(merchant);
		return null;
	}

	@Override
	public Merchant getMerchantByID(int merchantID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Merchant> getAllMerchants() {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
