package com.test.merchant;

import org.easymock.EasyMock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;

import com.own.database.dao.MerchantDAO;
import com.own.database.dao.MerchantDaoImpl;
import com.own.merchant.model.Merchant;


public class MerchantDaoTest {
	
	
	SessionFactory factory;
	
	Session session;
	
	private Merchant merchant = new Merchant();
	
	private MerchantDAO merchantDao;
	
	@Before
	public void setup()
	{
		factory = EasyMock.createMock(SessionFactory.class);
		session = EasyMock.createMock(Session.class);
		
		merchantDao = new MerchantDaoImpl();
		merchantDao.setSessionFactory(factory);
		
	}
	
	@Test
	public void testMerchantSave()
	{
//		EasyMock.expect(factory.getCurrentSession()).andReturn(session);
//		EasyMock.expect(session.save(merchant)).andReturn(merchant);
//		
//		EasyMock.replay(factory,session);
//		
//		//merchantDao.save(merchant);
//		
//		EasyMock.verify(factory,session);
//		
	}
	
	
	
}
