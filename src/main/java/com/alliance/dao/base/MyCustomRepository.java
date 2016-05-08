/**
 * 
 */
package com.alliance.dao.base;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qW
 * @description <em style="color='gray'">JPA阔展接口实现</em>
 * @date 2016年2月23日
 * @version 1.0.0
 */
@NoRepositoryBean
@Transactional
public class MyCustomRepository<T, ID extends Serializable>  extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID>  {

	private  EntityManager entityManager;
	
	@SuppressWarnings("unused")
	private  Class<T> t;
	/**
	 * @param domainClass
	 * @param em
	 */
	public MyCustomRepository(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		entityManager = em;
	}
	
	public MyCustomRepository(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager) {   
	    super(entityInformation, entityManager);   
	    this.entityManager = entityManager;
	    this.t = entityInformation.getJavaType();
	}  

	@Override
	public void saveOrUpdate(T t) {
		entityManager.merge(t);
	}

	@Override
	public Page<T> findPageByParameters(Map<String, Object> parameters,
			Pageable pageable) {
		Long id = (Long)parameters.get("topicId");
		Specification<T> spec = new Specification<T>() {

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				Path<Long> idExp = root.get("topicId");
				return cb.equal(idExp, id);
			}
		};
		
		return findAll(spec, pageable);
	}
	
}
