package com.jack.batis.core;

import java.lang.reflect.Proxy;

import com.jack.batis.execute.Excutor;
import com.jack.batis.execute.SimpleExcutor;
import com.jack.batis.proxy.MapperHandler;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午4:16:21 
*/
public class SqlSession {
	private Excutor executor =new SimpleExcutor();
	
	public <T> T select(String sql,Object[] parameter){
		sql=processSql(sql,parameter);
		return executor.select(sql);
	}
	
	public int delete(String sql,Object[] parameter){
		sql=processSql(sql,parameter);
		return executor.delete(sql);
	}
	
	public int update(String sql,Object[] parameter){
		sql=processSql(sql,parameter);
		return executor.update(sql);
	}
	
	public int insert(String sql,Object[] parameter){
		sql=processSql(sql,parameter);
		return executor.insert(sql);
	}
	
	/**
	 * To Process the sql,which will replace the placeholder with param
	 * @param sql
	 * @param parameter
	 * @return String
	 */
	private String processSql(String sql,Object[] parameter){
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> clazz){
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MapperHandler(this));
	}
}
