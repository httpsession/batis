package com.jack.batis.beans;

/*
 * 封装bean的factory
 */
public interface BeanFactory {
	JackBean getBean(String clzName);
}
