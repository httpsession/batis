package com.jack.batis.beans;

public interface BeanFactory {
	<T> T getBean(Class<T> requiredType);
	
	
	
}
