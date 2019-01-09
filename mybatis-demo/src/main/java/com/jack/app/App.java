package com.jack.app;


import java.lang.reflect.Method;

import com.alibaba.fastjson.JSONObject;
import com.jack.app.dao.UserDao;
import com.jack.batis.Batis;
import com.jack.batis.annotation.sql.Select;
import com.jack.batis.utils.MethodUtil;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2019年1月6日 下午4:57:50 
*/
public class App {
	public static void main(String[] args) {
		//指定dao层所在的包
		/*Batis.init("com.jack.app.dao");
		UserDao userDao =Batis.getMapper(UserDao.class);
		String json = JSONObject.toJSONString(userDao.getUserById("6"));
		System.out.println(json);*/
		try {
			Class<?> clz = Class.forName("com.jack.batis.execute.Excutor");
			Method[] methods = clz.getMethods();
			for (Method method : methods) {
				String returnType=method.getReturnType().toString();
				String returnTypeToGenericString=method.getReturnType().toGenericString();
				String genericReturnType =MethodUtil.extract(method.getGenericReturnType().toString()) ;
				System.out.println(returnType+"--------"+genericReturnType+"----------"+returnTypeToGenericString);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClassPathXmlApplicationContext ;
		BeanFactory;
	}
}
