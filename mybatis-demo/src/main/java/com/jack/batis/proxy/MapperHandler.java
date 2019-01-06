package com.jack.batis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.jack.batis.core.Configuration;
import com.jack.batis.core.SqlSession;
import com.jack.batis.utils.Action;
import com.jack.batis.utils.ActionAndSql;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午5:43:13 
*/
public class MapperHandler implements InvocationHandler {
	
	private SqlSession sqlSession=null;
	
	public MapperHandler(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String key= method.getDeclaringClass().getName()+"."+method.getName();
		ActionAndSql actionAndSql=Configuration.statementMap.get(key);
		Object result=null;
		switch(actionAndSql.getAction()){
			case Action.select:
				result=sqlSession.select(actionAndSql.getSql(), args);
				break;
			case Action.update:
				result=sqlSession.update(actionAndSql.getSql(), args);
				break;
			case Action.insert:
				result=sqlSession.insert(actionAndSql.getSql(), args);
				break;
			case Action.delete:
				result=sqlSession.delete(actionAndSql.getSql(), args);
				break;
			default:
				throw new RuntimeException("Error! illegal operation!");
		}
		return result;
	}

	
	/*if(Configuration.namespace.equals(clazzName)){
	String sql=Configuration.mapStateMent.get(method.getName());
	return sqlSession.selectOne(sql, String.valueOf(args[0]));
	}*/
}
