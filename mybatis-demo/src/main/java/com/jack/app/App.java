package com.jack.app;


import com.alibaba.fastjson.JSONObject;
import com.jack.app.dao.UserDao;
import com.jack.batis.Batis;
import com.jack.batis.annotation.Select;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2019年1月6日 下午4:57:50 
*/
public class App {
	public static void main(String[] args) {
		//指定dao层所在的包
		Batis.init("com.jack.app.dao");
		UserDao userDao =Batis.getMapper(UserDao.class);
		String json = JSONObject.toJSONString(userDao.getUserById("6"));
		System.out.println(json);
	}
}
