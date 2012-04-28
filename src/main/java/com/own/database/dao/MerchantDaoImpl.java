package com.own.database.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.own.merchant.model.Merchant;

@Repository
public class MerchantDaoImpl  implements MerchantDAO{

	private static Logger logger = Logger.getLogger(MerchantDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Merchant save(Merchant merchant) {
		
		Session currentSession = this.sessionFactory.getCurrentSession();
		Integer insertID = (Integer) currentSession.save(merchant);
		logger.info("Merchant:"+ insertID);
		Merchant response = (Merchant)currentSession.load(Merchant.class, insertID);
		return response;
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

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
