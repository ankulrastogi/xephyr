package com.own.merchant.model.sql.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MerchantAccountIDGenerator implements IdentifierGenerator{

	private static Logger logger = Logger.getLogger(MerchantAccountIDGenerator.class);
	
	private static String ID_PREFIX="account_";
	@Override
	public synchronized Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {
		
		Connection conn = session.connection();
		String userID = null;
		try {
			PreparedStatement stmt = conn.prepareStatement("select count(*) from merchantAccount");
			ResultSet executeQuery = stmt.executeQuery();
			if(executeQuery.next())
			{
				logger.info("RESULT:" + executeQuery.getInt(1) );
				userID = ID_PREFIX + executeQuery.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userID;
	}

}
