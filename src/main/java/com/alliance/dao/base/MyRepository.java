/**
 * 
 */
package com.alliance.dao.base;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author qW
 * @description <em style="color='gray'">JPA阔展接口</em>
 * @date 2016年2月23日
 * @version 1.0.0
 */
public interface MyRepository<T , ID extends Serializable> extends JpaRepository<T, ID>{
	
	/**
	 *<em>保存更新</em> 
	 * @param t 实体
	 */
	void saveOrUpdate(T t);
	
	/**
	 * <em>参数分页查询</em>
	 * 
	 * @param parameters
	 * @param pageable
	 * @return
	 */
	Page<T> findPageByParameters(Map<String, Object> parameters , Pageable pageable);
}
