package com.jack.batis.beans;

import java.util.HashMap;
import java.util.Set;

public class DefaultBeanFactory implements BeanFactory{
	
	private HashMap<String,Set> beanContainer=new HashMap<String,Set>();

	public <T> T getBean(Class<T> requiredType) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> boolean isPrimary(Class<T> clz) {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> boolean isInterface(Class<T> clz) {
		// TODO Auto-generated method stub
		return false;
	}
}
