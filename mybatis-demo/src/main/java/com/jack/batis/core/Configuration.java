package com.jack.batis.core;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.base.Strings;
import com.jack.batis.annotation.Delete;
import com.jack.batis.annotation.Insert;
import com.jack.batis.annotation.Mapper;
import com.jack.batis.annotation.Select;
import com.jack.batis.annotation.Update;
import com.jack.batis.utils.Action;
import com.jack.batis.utils.ClassUtil;
import com.jack.batis.utils.ActionAndSql;

/** 
* @author	longjie 
* @date 	2018年12月25日 下午3:53:23 
*/
public class Configuration {
	public static final Map<String,ActionAndSql> statementMap=new ConcurrentHashMap<String,ActionAndSql>(32);
	
	/**
	 * scan mapper in packageName
	   *  在指定的包中扫描Mapper
	 * @param packageName 
	 */
	public static void mapperScanner(String packageName){
		ClassLoader clzLoader = Thread.currentThread().getContextClassLoader();
		Set<String> clzNameSet=null;
		 try {
			 clzNameSet = ClassUtil.getClassName(packageName, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Class<?> clz=null;
		for (String clzName : clzNameSet) {
			try {
				//load class
				clz=clzLoader.loadClass(clzName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			//if class annotated by @Mapper,put the sql in method into statement map
			if(isAnnotatedByMapper(clz)){
				putToStatementMap(clzName,clz);
			}
		}
	}
	
	/**
	 * put sql statement which annotated in method into statementMap
	 * @param clzName
	 * @param clz 
	 */
	@SuppressWarnings("rawtypes") 
	private static void putToStatementMap(String clzName,Class clz){
		Method[] methods = clz.getMethods();
		for (Method method : methods) {
			if(method.isAnnotationPresent(Select.class)){
				Select select = method.getAnnotation(Select.class);
				String sql=select.value();
				if(!Strings.isNullOrEmpty(sql)){
					statementMap.put(clzName+"."+method.getName(), new ActionAndSql(Action.select,sql));
				}else{
					throw new RuntimeException("Error! Your @Select has no value!");
				}
			}else if(method.isAnnotationPresent(Update.class)){
				Update update = method.getAnnotation(Update.class);
				String sql=update.value();
				if(!Strings.isNullOrEmpty(sql)){
					statementMap.put(clzName+"."+method.getName(), new ActionAndSql(Action.update,sql));
				}else{
					throw new RuntimeException("Error! Your @Update t has no value!");
				}
			}else if(method.isAnnotationPresent(Insert.class)){
				Insert insert = method.getAnnotation(Insert.class);
				String sql=insert.value();
				if(!Strings.isNullOrEmpty(sql)){
					statementMap.put(clzName+"."+method.getName(), new ActionAndSql(Action.insert,sql));
				}else{
					throw new RuntimeException("Error! Your @Insert has no value!");
				}
			}else if(method.isAnnotationPresent(Delete.class)){
				Delete delete = method.getAnnotation(Delete.class);
				String sql=delete.value();
				if(!Strings.isNullOrEmpty(sql)){
					statementMap.put(clzName+"."+method.getName(), new ActionAndSql(Action.delete,sql));
				}else{
					throw new RuntimeException("Error! Your @Delete has no value!");
				}
			}
		}
	}
	
	private static boolean isAnnotatedByMapper(Class<?> clz){
		if(clz!=null){
			if(clz.isAnnotationPresent(Mapper.class)){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * 
	 * 
    public static String namespace="com.jack.app.dao.UserDao";
	
	public void scanner(){
		
	}
	static{
		//模拟xml中的id与sql语句
		mapStateMent.put("getUserById", "select * from mall_user where user_id = ?");
	}
	 */
}
