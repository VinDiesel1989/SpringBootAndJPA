/**
 * 
 */
package com.alliance.service;

import java.util.List;

import com.alliance.model.User;
import com.alliance.vo.LoginResultVo;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年2月29日
 * @version 1.0.0
 */
public interface UserService {

	List<User> findAllUsers();
	
	void registerUser(User user);
	
	LoginResultVo login(String userName , String passWord);
	
	User findUserByName(String userName);
	
	User findUserById(Long userId);
}
