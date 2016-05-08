/**
 * 
 */
package com.alliance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alliance.service.UserService;
import com.alliance.support.WebCode;
import com.alliance.vo.LoginResultVo;

/**
 * @author qW
 * @description <em style="color='gray'">用户控制器</em>
 * @date 2016年3月6日
 * @version 1.0.0
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/loginPage" , method = {RequestMethod.GET})
	public ModelAndView index(HttpServletResponse response){
		ModelAndView  view = new ModelAndView("/login/login");
		return view;
	}
	
	@RequestMapping(value = "/doLogin" , method = {RequestMethod.POST})
	public @ResponseBody LoginResultVo   login(@RequestParam(value = "loginType")int loginType , 
			@RequestParam(value ="userName")String userName , 
			@RequestParam(value = "passWord")String passWord,
			HttpServletRequest request , HttpServletResponse response){
		switch (loginType) {
		case WebCode.LOGIN_TYPE_NORMAL:
			LoginResultVo loginResultVo = userService.login(userName, passWord);
			return loginResultVo;
		default:
			return null;
		}
	}
	
	@RequestMapping(value = "/doRegister",method={RequestMethod.POST})
	public ModelAndView register(){
		ModelAndView view = new ModelAndView("/register/success");
		return view;
	}
	
}
