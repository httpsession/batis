package com.jack.batis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2019年1月6日 上午10:11:46 
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Update {
	 String value();
}
