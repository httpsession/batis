package com.jack.app;


import java.lang.reflect.Method;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;
import com.jack.app.dao.UserDao;
import com.jack.app.domain.User;
import com.jack.batis.Batis;
import com.jack.batis.annotation.Bean;
import com.jack.batis.annotation.Mapper;
import com.jack.batis.annotation.Primary;
import com.jack.batis.annotation.Service;
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
		
	/*	Batis.init("com.jack.app");
		UserDao userDao =Batis.getMapper(UserDao.class);
		String json = JSONObject.toJSONString(userDao.getUserById("6"));
		System.out.println(json);*/
		
		/*String clzPath = System.getProperty("user.dir");
		System.out.println(clzPath);
		URL xmlpath = App.class.getClassLoader().getResource("*");
        System.out.println(xmlpath);*/
        /*System.out.println(Mapper.class.isAnnotationPresent(Bean.class));
        System.out.println(UserDao.class.isAnnotationPresent(Bean.class));
        System.out.println( UserDao.class .getDeclaredAnnotationsByType(Bean.class));*/
        //System.out.println( Select.class .getDeclaredAnnotationsByType(Bean.class));
        System.out.println( UserDao.class.isAnnotationPresent(Mapper.class));
        System.out.println( UserDao.class.isAnnotationPresent(Bean.class));
        System.out.println( JSONObject.toJSONString(UserDao.class.getAnnotatedInterfaces()));
        System.out.println( UserDao.class.getAnnotatedSuperclass());
        System.out.println( JSONObject.toJSONString(UserDao.class.getAnnotations()));
        System.out.println( JSONObject.toJSONString(UserDao.class.getAnnotations()));
	}
}
