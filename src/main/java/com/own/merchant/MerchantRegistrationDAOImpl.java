package com.own.merchant;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.own.merchant.model.MerchantRegistration;

@Repository
public class MerchantRegistrationDAOImpl implements MerchantRegistrationDAO {

	private Logger logger = Logger.getLogger(MerchantRegistrationDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public MerchantRegistration save(MerchantRegistration registration) {

		Session currentSession = this.sessionFactory.getCurrentSession();
		Integer insertID = (Integer) currentSession.save(registration);
		logger.info("Registration:" + insertID);
		MerchantRegistration response = (MerchantRegistration) currentSession
				.load(MerchantRegistration.class, insertID);
		return response;
	}

	@Override
	public MerchantRegistration getRegistrationByEmail(String emailID) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<MerchantRegistration> result = (List<MerchantRegistration>) currentSession
				.createCriteria(MerchantRegistration.class)
				.add(Restrictions.eq("email", emailID)).list();

		if(null == result || result.size() == 0)
			return null;
		
		return result.get(0);
	}

}
