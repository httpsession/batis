package com.jack.batis.beans;

/**
 * bean包装类
 * @author lilongjie
 *
 */
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
