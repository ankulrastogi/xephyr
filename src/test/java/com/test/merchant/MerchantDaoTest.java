package com.test.merchant;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.easymock.PowerMock.*;




import com.own.database.dao.MerchantDAO;
import com.own.database.dao.MerchantDaoImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MerchantDaoImpl.class)
public class MerchantDaoTest {
	
	@Mock
	SessionFactory factory;
	
	private MerchantDAO merchantDao;
	
	@Before
	public void setup()
	{
		merchantDao = new MerchantDaoImpl();
	}
	
	@Test
	public void testMerchantSave()
	{
		
	}
	
	

}
