package com.jack.batis.core;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.HashMap;

import com.jack.batis.execute.Excutor;
import com.jack.batis.execute.SimpleExcutor;
import com.jack.batis.proxy.MapperHandler;
import com.jack.batis.utils.SqlParseUtil;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午4:16:21 
*/
public class SqlSession {
	private Excutor executor =new SimpleExcutor();
	
	public <T> T select(Method method,String sql,Object[] parameter){
		sql=processSql(method,sql,parameter);
		return executor.select(sql);
	}
	
	public int delete(Method method,String sql,Object[] parameter){
		sql=processSql(method,sql,parameter);
		return executor.delete(sql);
	}
	
	public int update(Method method,String sql,Object[] parameter){
		sql=processSql(method,sql,parameter);
		return executor.update(sql);
	}
	
	public int insert(Method method,String sql,Object[] parameter){
		sql=processSql(method,sql,parameter);
		return executor.insert(sql);
	}
	
	/**
	 * To Process the sql,which will replace the placeholder with param
	 * @param sql
	 * @param parameter
	 * @return String
	 */
	private String processSql(Method method,String sql,Object[] args){
		Parameter[] params = method.getParameters();
		HashMap<String,String> paramAndValuePair=new HashMap<String,String>();
		String processedSql=null;
		if(params.length==args.length) {
			for(int i=0;i<params.length;++i) {
				//paramAndValuePair.put(params[i].getName(), String.valueOf(args[i]));
				paramAndValuePair.put("userId", String.valueOf(args[i]));
			}
			processedSql=SqlParseUtil.parse(sql,paramAndValuePair);
		}
		return processedSql;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> clazz){
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MapperHandler(this));
	}
}
