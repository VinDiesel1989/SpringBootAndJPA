package com.alliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 
 */

/**
 * @author qW
 * @description <em style="color='gray'">应用入口</em>
 * @date 2016年1月25日
 * @version 1.0.0
 */
//@EnableJpaRepositories(
//basePackages = "com.alliance.dao" 
//,entityManagerFactoryRef="entityManagerFactory" 
//,repositoryFactoryBeanClass=com.alliance.dao.base.MyRepositoryFactoryBean.class,
//transactionManagerRef="transactionManager")
//@EnableTransactionManagement
@ImportResource(locations= "classpath:mvc.xml")
@SpringBootApplication(scanBasePackages = "com.alliance")
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableAutoConfiguration
public class ApplicationMain extends WebMvcConfigurerAdapter{

	private static ApplicationContext applicationContext;
	/*
	 * (拦截器配置)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
	}

	public static ApplicationContext getApplicationContext(){
		if(applicationContext == null){
			throw new NullPointerException("load spring application context failure");
		}
		return applicationContext;
	}
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ApplicationMain.class);
		applicationContext = application.run(args);
	}
	
}
