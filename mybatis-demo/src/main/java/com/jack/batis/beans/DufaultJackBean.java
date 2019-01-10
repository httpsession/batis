package com.jack.batis.beans;

/**
  *    默认的bean包装类
 * @author lilongjie
 *
 */
public class DufaultJackBean<T> implements JackBean<T> {
	
	private String beanClassName;
	
	private String parentName;
	
	private boolean isPrimary;
	
	private boolean isAbstract;
	///被包装bean的实例
	private T instance;

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public T getInstance() {
		return instance;
	}

	public void setInstance(T instance) {
		this.instance = instance;
	}
}
