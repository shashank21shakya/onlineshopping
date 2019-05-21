package com.yash.shoppingbackedn.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.cj.xdevapi.SessionFactory;

@Configuration
@ComponentScan(basePackages= {"com.yash.shoppingbackedn.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL ="";
	private final static String DATABASE_DRIVER ="";
	private final static String DATABASE_DIALECT ="";
	private final static String DATABASE_USERNAME ="";
	private final static String DATABASE_PASSWORD ="";

@Bean
public DataSource getDataSource() {
	
	BasicDataSource basicDataSource  =new BasicDataSource();
	basicDataSource.setDriverClassName(DATABASE_DRIVER);
	basicDataSource.setUrl(DATABASE_URL);
	basicDataSource.setUsername(DATABASE_USERNAME);
	basicDataSource.setPassword(DATABASE_PASSWORD);
	return basicDataSource;
}

@Bean
public SessionFactory  getSessionFactory(DataSource dataSource) {
	
	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.scanPackages("com.yash.shoppingbackedn.dto");

	return 	(SessionFactory) sessionBuilder.buildSessionFactory();
	
	
}

private Properties getHibernateProperties() {
	
	Properties properties = new Properties();
	properties.put("hibernate.dialect", DATABASE_DIALECT);
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.format_sql", "true");
	return properties;
	
	
}

@Bean
public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory) {
	
	HibernateTransactionManager transactionManager = new HibernateTransactionManager((org.hibernate.SessionFactory) sessionFactory);
	return transactionManager;
	}
}
