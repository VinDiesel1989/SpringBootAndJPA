/**
 * 
 */
package com.alliance.support.interceptors;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * @author qW
 * @description <em style="color='gray'">登录验证器</em>
 * @date 2016年3月17日
 * @version 1.0.0
 */
public class LoginValidationHandler implements WebRequestInterceptor{

	
	@Override
	public void preHandle(WebRequest request) throws Exception {
		
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex)
			throws Exception {
		
	}

}
