/**
 * 
 */
package com.alliance.support;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年3月2日
 * @version 1.0.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.alliance.dao" 
,entityManagerFactoryRef="entityManagerFactoryMaster" 
,repositoryFactoryBeanClass=com.alliance.dao.base.MyRepositoryFactoryBean.class,
transactionManagerRef="transactionManagerMaster")
public class RepositoryMasterConfig {

	@Autowired
	private JpaProperties jpaProperties;
	
	@Autowired
	@Qualifier("masterDataSource")
	private DataSource dataSource;
	
	@Bean(name = "entityManagerMaster")
	@Primary
	public EntityManager entityManager(EntityManagerFactoryBuilder builder){
		return entityManagerFactoryMaster(builder).getObject().createEntityManager();
	}
	
	@Bean(name = "entityManagerFactoryMaster")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryMaster(EntityManagerFactoryBuilder builder){
		return builder
				.dataSource(dataSource)
				.properties(getVendorProperties(dataSource)).packages("com.alliance.model")
				.persistenceUnit("masterPersistenceUnit")
				.build();
	}
	
	private Map<String, String> getVendorProperties(DataSource dataSource){
		return jpaProperties.getHibernateProperties(dataSource);
	}
	
	@Bean(name = "transactionManagerMaster")
	@Primary
	PlatformTransactionManager transactionManagerMaster(EntityManagerFactoryBuilder builder){
		return new JpaTransactionManager(entityManagerFactoryMaster(builder).getObject());
	}
}
