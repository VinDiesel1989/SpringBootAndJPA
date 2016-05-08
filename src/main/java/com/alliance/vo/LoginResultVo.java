/**
 * 
 */
package com.alliance.vo;

import com.alliance.model.User;

/**
 * @author qW
 * @description <em style="color='gray'">登录结果VO</em>
 * @date 2016年3月17日
 * @version 1.0.0
 */
public class LoginResultVo {

	private User user;
	private String loginMessage;
	private boolean loginSuccess;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getLoginMessage() {
		return loginMessage;
	}
	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}
	public boolean isLoginSuccess() {
		loginSuccess = user != null;
		return loginSuccess;
	}
	public void setLoginSuccess(boolean loginSuccess) {
		this.loginSuccess = loginSuccess;
	}
	
}
