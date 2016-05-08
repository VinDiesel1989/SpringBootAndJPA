/**
 * 
 */
package com.alliance.dao;

import java.util.List;

import com.alliance.dao.base.MyRepository;
import com.alliance.model.Indus;

/**
 * @author qW
 * @description <em style="color='gray'">行业(树)DAO</em>
 * @date 2016年2月28日
 * @version 1.0.0
 */
public interface IndustryDao extends MyRepository<Indus, Long>{

	List<Indus> findIndusByIndexAndAvailable(int index , boolean available);
}
