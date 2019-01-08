package com.jack.batis.annotation;
/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午2:56:38 
*/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jack.batis.utils.Action;
/** 
* @author	longjie 
* @date 	2019年1月6日 上午10:11:18 
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
	 String value();
	 final int action=Action.select;
}
