package com.own.configuration;

import static junit.framework.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataAccessConfiguration.class})
@ActiveProfiles("test")
public class DataAccessConfigurationTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void check_data_source_not_null()
	{
		assertNotNull(dataSource);
	}
	
	@Test
	public void check_entity_manager_not_null()
	{
		assertNotNull(entityManager);
	}
}
