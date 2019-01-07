package com.jack.app;


import com.jack.app.dao.UserDao;
import com.jack.batis.Batis;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2019年1月6日 下午4:57:50 
*/
public class App {
	public static void main(String[] args) {
		Batis.init("com.jack.app.dao");
		UserDao mapper =Batis.getMapper(UserDao.class);
		int count=mapper.deleteUserById("4");
		System.out.println("delete "+count+" row record!");
	}
}
