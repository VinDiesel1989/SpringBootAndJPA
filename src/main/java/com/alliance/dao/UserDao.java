/**
 * 
 */
package com.alliance.dao;

import java.util.List;

import com.alliance.dao.base.MyRepository;
import com.alliance.model.User;

/**
 * @author qW
 * @description <em style="color='gray'">用户DAO</em>
 * @date 2016年2月23日
 * @version 1.0.0
 */
public interface UserDao extends MyRepository<User, Long>{

	/**
	 * <em>主id查询用户信息</em>
	 * @param id
	 * @return
	 */
	User  findUserById(Long id);
	/**
	 * <em>通过微信公众id查询用户信息</em>
	 * @param openId
	 * @return
	 */
	User  findUserByOpenId(String openId);
	/**
	 * <em>通过用户名查询用户</em>
	 * @param userName
	 * @return
	 */
	List<User> findByUserName(String userName);
	
	/**
	 * 用户名查询唯一用户
	 * @param userName
	 * @return
	 */
	User  findUserByUserName(String userName);
}
