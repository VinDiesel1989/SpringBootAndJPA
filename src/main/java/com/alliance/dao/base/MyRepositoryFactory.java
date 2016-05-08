/**
 * 
 */
package com.alliance.dao.base;

import java.io.Serializable;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.*;   

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

/**
 * @author qW
 * @description <em style="color='gray'">接口实现类工厂</em>
 * @date 2016年2月23日
 * @version 1.0.0
 */
public class MyRepositoryFactory extends JpaRepositoryFactory {
	public MyRepositoryFactory(EntityManager entityManager) {   
        super(entityManager);   
    }   
  
    
	@SuppressWarnings("unchecked")
	@Override
	protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
			RepositoryInformation information, EntityManager entityManager) {
    	JpaEntityInformation<Object, Serializable> entityMetadata = mock(JpaEntityInformation.class);   
        when(entityMetadata.getJavaType()).thenReturn((Class<Object>) information.getDomainType());   
		return new MyCustomRepository<Object, Serializable>(entityMetadata, entityManager); 
	}
	
	/*  
     * (non-Javadoc)  
     *   
     * @see  
     * org.springframework.data.repository.support.RepositoryFactorySupport# 
     * getRepositoryBaseClass() 
     */  
    @Override  
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {   
  
        return MyCustomRepository.class;   
    }   
}
