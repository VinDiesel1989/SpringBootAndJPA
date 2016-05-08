/**
 * 
 */
package com.alliance.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author qW
 * @description <em style="color='gray'">TODO</em>
 * @date 2016年3月17日
 * @version 1.0.0
 */
@Aspect
@Component
public class CacheLoginAspect {

	private static final Log LOGGER = LogFactory.getLog(CacheLoginAspect.class);
	
	/**
	 *Service层切点
	 */
	@Pointcut("@annotation(com.alliance.support.annotation.CacheLogin)")
	public void loginCacheAspect(){
		
	}
	
	
	/**
	 * Service层方法前置通知
	 * @param point
	 */
	@Before("loginCacheAspect()")
	public void doBefore(JoinPoint point){
		LOGGER.info("<<< 缓存用户登录信息 >>>");
		return;
	}
	
	/**
	 * Service层方法后置通知
	 * @param point
	 */
	@After("loginCacheAspect()")
	public void doAfter(JoinPoint point){
		LOGGER.info("<<< 执行缓存SUCCESS >>>");
	}
}
