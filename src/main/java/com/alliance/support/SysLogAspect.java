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
 * @date 2016年3月3日
 * @version 1.0.0
 */
@Aspect
@Component
public class SysLogAspect {

	private static final Log LOGGER = LogFactory.getLog(SysLogAspect.class);
	
	/**
	 *Service层切点
	 */
	@Pointcut("@annotation(com.alliance.support.annotation.SysServiceLog)")
	public void serviceAspect(){
		
	}
	
	/**
	 * Service层方法前置通知
	 * @param point
	 */
	@Before("serviceAspect()")
	public void doBefore(JoinPoint point){
		LOGGER.info("<<< 前置通知 >>>");
	}
	
	/**
	 * Service层方法后置通知
	 * @param point
	 */
	@After("serviceAspect()")
	public void doAfter(JoinPoint point){
		LOGGER.info("<<< 后置通知 >>>");
	}
}
