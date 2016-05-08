/**
 * 
 */
package com.alliance.support.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author qW
 * @description <em style="color='gray'">缓存信息登录</em>
 * @date 2016年3月17日
 * @version 1.0.0
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheLogin {

	String description() default "";
}
