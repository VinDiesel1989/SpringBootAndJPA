/**
 * 
 */
package com.alliance.support;


//import javax.persistence.EntityManagerFactory;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.web.config.EnableSpringDataWebSupport;
//import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
//import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author qW
 * @description <em style="color='gray'">基础配置</em>
 * @date 2016年2月28日
 * @version 1.0.0
 */
//@SuppressWarnings("deprecation")
@Configuration
//@EnableSpringDataWebSupport
public class MyConfiguration {
	
	/*@Autowired
	@Qualifier("entityManagerFactoryMaster")
	private EntityManagerFactory entityManagerFactory;*/

	/*@Bean
	public OpenEntityManagerInViewInterceptor getOpenEntityManagerInViewInterceptor(){
		OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor = new OpenEntityManagerInViewInterceptor();
		openEntityManagerInViewInterceptor.setEntityManagerFactory(entityManagerFactory);
		return openEntityManagerInViewInterceptor;
	}*/
	
	/*@Bean
	public DefaultAnnotationHandlerMapping getDefaultAnnotationHandlerMapping(){
		DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping = new DefaultAnnotationHandlerMapping();
		Object[] interceptors = new Object[]{getOpenEntityManagerInViewInterceptor()};
		defaultAnnotationHandlerMapping.setInterceptors(interceptors);
		return defaultAnnotationHandlerMapping;
	}*/
	
	@Bean
	public InternalResourceViewResolver internalViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(1);
		return viewResolver;
	}
}
