package com.jack.batis.annotation.sql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jack.batis.utils.Action;

/** 
*   被标记的方法执行删除操作
* @author	longjie 
* @date 	2019年1月6日 上午10:10:26 
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Delete{
	 String value();
	 final int action=Action.delete;
}
