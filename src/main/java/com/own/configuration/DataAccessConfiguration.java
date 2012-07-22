package com.own.configuration;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@ImportResource({"classpath:xml/database-access.xml"})
@PropertySource({"classpath:properties/${spring.profiles.active:dev}/data-access.properties"})
public class DataAccessConfiguration {

	@Autowired
	private Environment environment;
	
	@Bean(autowire=Autowire.BY_TYPE)
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws PropertyVetoException
	{
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.setPersistenceUnitName("test-bed");
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(environment.getProperty("em.package.scan"));
		factoryBean.setJpaPropertyMap(jpaProperties());
		return factoryBean;
	}
	
	@Bean
	public EntityManager entityManager() throws PropertyVetoException
	{
		return entityManagerFactoryBean().getObject().createEntityManager();
	}
	
	private Map<String, ?> jpaProperties() {
		Map<String, String> propMap = new HashMap<String, String>();
		propMap.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		propMap.put("hibernate.show_sql", environment.getProperty("hibernate.show.sql"));
		return propMap;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		HibernateJpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
		adaptor.setGenerateDdl(Boolean.valueOf(environment.getProperty("hibernate.generateddl")));
		adaptor.setShowSql(Boolean.valueOf(environment.getProperty("hibernate.show.sql")));
		return adaptor;
	}
	@Bean
	public DataSource dataSource() throws PropertyVetoException
	{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(environment.getProperty("jdbc.driverClassName"));
		dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		dataSource.setUser(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		dataSource.setIdleConnectionTestPeriod(Integer.valueOf(environment
				.getProperty("ds.idle.test")));
		dataSource.setMaxPoolSize(Integer.valueOf(environment
				.getProperty("ds.max.pool.size")));
		dataSource.setMaxStatements(Integer.valueOf(environment
				.getProperty("ds.statement.max")));
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() throws PropertyVetoException
	{
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		txManager.setJpaDialect(new HibernateJpaDialect());
		return txManager;
			
	}
}
