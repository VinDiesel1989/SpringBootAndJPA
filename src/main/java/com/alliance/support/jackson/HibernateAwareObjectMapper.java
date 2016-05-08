/**
 * 
 */
package com.alliance.support.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年4月1日
 * @version 1.0.0
 */
public class HibernateAwareObjectMapper extends ObjectMapper{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3454964986193101578L;

	public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
	
	
}
