package com.jack.batis.core;

import java.lang.reflect.Proxy;

import com.jack.batis.excute.Excutor;
import com.jack.batis.excute.SimpleExcutor;
import com.jack.batis.proxy.MapperHandler;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午4:16:21 
*/
public class SqlSession {
	private Excutor excutor =new SimpleExcutor();
	
	public <T> T selectOne(String statement,Object parameter){
		return excutor.query(statement, parameter);
	}
	
	public <T> T getMapper(Class<T> clazz){
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MapperHandler(this));
	}
}
