/**
 * 
 */
package com.alliance.dao.base;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * @author qW
 * @description <em style="color='gray'">JAP实现类工厂Bean</em>
 * @date 2016年2月23日
 * @version 1.0.0
 */
public class MyRepositoryFactoryBean<T extends JpaRepository<Object, Serializable>> extends JpaRepositoryFactoryBean<T, Object, Serializable>{

	@Override  
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {  
  
        return new MyRepositoryFactory(em);
        
    }  
}
