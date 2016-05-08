/**
 * 
 */
package com.alliance.dao;

import java.util.List;

import com.alliance.dao.base.MyRepository;
import com.alliance.model.Expr;
import com.alliance.model.User;

/**
 * @author qW
 * @description <em style="color='gray'">用户经验DAO</em>
 * @date 2016年2月28日
 * @version 1.0.0
 */
public interface ExprDao extends MyRepository<Expr, Long>{
	
	List<Expr> findScoreByUser(User user);
}
