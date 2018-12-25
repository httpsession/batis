package com.jack.batis.proxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.jack.batis.anno.Select;
import com.jack.batis.core.Configuration;
import com.jack.batis.core.SqlSession;

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
		/*Annotation[] annos = method.getDeclaredAnnotations();
		for (Annotation annotation : annos) {
			Class<? extends Annotation> annoClz = annotation.annotationType();
			if(annoClz==Select.class){
				
			}
		}*/
		String clazzName = method.getDeclaringClass().getName();
		if(Configuration.namespace.equals(clazzName)){
			String sql=Configuration.mapStateMent.get(method.getName());
			return sqlSession.selectOne(sql, String.valueOf(args[0]));
		}
		return null;
	}

}
