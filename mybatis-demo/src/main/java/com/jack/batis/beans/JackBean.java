package com.jack.batis.beans;

public interface JackBean {
	String getParentName();
	
	void setParentName(String parentName);
	
	void setBeanClassName(String beanClassName);
	
	String getBeanClassName();
	
	void setPrimary(boolean primary);
	
	boolean isPrimary();
	
	void setAbstract(boolean isAbstract);
	
	boolean isAbstract();
}
