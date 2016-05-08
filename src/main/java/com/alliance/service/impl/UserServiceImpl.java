/**
 * 
 */
package com.alliance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alliance.dao.UserDao;
import com.alliance.model.User;
import com.alliance.service.UserService;
import com.alliance.support.annotation.CacheLogin;
import com.alliance.support.annotation.SysServiceLog;
import com.alliance.support.utils.MD5Util;
import com.alliance.vo.LoginResultVo;

/**
 * @author qW
 * @description <em style="color='gray'">用户业务处理</em>
 * @date 2016年2月29日
 * @version 1.0.0
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@SysServiceLog(description = "查询所有用户数据")
	@Override
	@Transactional(rollbackFor=Exception.class , transactionManager = "transactionManagerMaster")
	public List<User> findAllUsers() {
		List<User> users = userDao.findAll();
		return users;
	}

	@Override
	public void registerUser(User user) {
		
	}

	@CacheLogin(description = "缓存登录用户信息")
	@Override
	@Transactional(readOnly = true)
	public LoginResultVo login(String userName, String passWord) {
		LoginResultVo loginResultVo = new LoginResultVo();
		if(StringUtils.isEmpty(userName)){
			loginResultVo.setLoginMessage("用户名为空");
			return loginResultVo;
		}
		User user = userDao.findUserByUserName(userName);
		if(user == null)
		{
			loginResultVo.setLoginMessage("未注册此用户");
			return loginResultVo;
		}
		String md5PassWord = MD5Util.string2MD5(passWord);
		if(!user.getUserPass().equals(md5PassWord))
		{
			loginResultVo.setLoginMessage("密码输入错误");
			return loginResultVo;
		}
		loginResultVo.setUser(user);
		loginResultVo.setLoginMessage("登录成功");
		return loginResultVo;
	}

	@Override
	public User findUserByName(String userName) {
		User  user = userDao.findUserByUserName(userName);
		return user;
	}

	@Override
	public User findUserById(Long userId) {
		return userDao.findOne(userId);
	}
}
