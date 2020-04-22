package com.example.datatest.resolver;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Author xuebiao
 * @Date 2020年4月22日
 * @Description: 当前登录人
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

	/**
	 * 当前用户在request中的名字
	 *
	 * @return
	 */
	String value() default "currentUser";
}
