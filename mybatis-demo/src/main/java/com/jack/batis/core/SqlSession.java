package com.jack.batis.core;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;

import com.jack.batis.execute.Excutor;
import com.jack.batis.execute.SimpleExcutor;
import com.jack.batis.proxy.MapperHandler;
import com.jack.batis.utils.MethodUtil;
import com.jack.batis.utils.SqlParseUtil;

/** 
* @author	longjie 
* @date 	2018年12月25日 下午4:16:21 
*/
public class SqlSession {
	private Excutor executor =new SimpleExcutor();
	
	/**
	 * Execute query
	   *   执行查询
	 */
	public List select(Method method,String sql,Object[] parameter){
		sql=processSql(method,sql,parameter);
		//get return type of method
		String retType = MethodUtil.extract(method.getGenericReturnType().toString());
		ClassLoader clzLoader = Thread.currentThread().getContextClassLoader();
		Class<?> returnClz=null;
		try {
			//load return type's class
			returnClz = clzLoader.loadClass(retType);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return executor.select(sql,returnClz);
	}
	
	/**
	 * 
	 * @param method
	 * @param sql
	 * @param parameter
	 * @return
	 */
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
	 * To process the sql,which will replace the placeholder with param
	   *   将方法的参数值映射到sql语句中占位符
	 * @param sql
	 * @param parameter
	 * @return String
	 */
	private String processSql(Method method,String sql,Object[] args){
		Parameter[] params = method.getParameters();
		//参数与参数值
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
	
	/**
	   *    返回dao层接口的动态代理实例
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> clazz){
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MapperHandler(this));
	}
}
