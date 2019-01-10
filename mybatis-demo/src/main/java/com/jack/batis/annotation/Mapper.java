package com.jack.batis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
*  被@Mapper标记的类属于bean的范畴
* @author	longjie 
* @date 	2018年12月25日 下午7:31:52 
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Bean
public @interface Mapper {

}
