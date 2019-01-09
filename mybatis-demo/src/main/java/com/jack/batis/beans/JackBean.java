package com.jack.batis.beans;

public interface JackBean<T> {
	
	T getInstance();
	
	void setInstance(T instance);
	
	String getParentName();
	
	void setParentName(String parentName);
	
	void setBeanClassName(String beanClassName);
	
	String getBeanClassName();
	
	void setPrimary(boolean primary);
	
	boolean isPrimary();
	
	void setAbstract(boolean isAbstract);
	
	boolean isAbstract();
	

	
}
