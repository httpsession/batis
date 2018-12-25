package com.jack.batis.demo;

import com.jack.app.dao.UserDao;
import com.jack.app.domain.User;
import com.jack.batis.core.SqlSession;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午10:11:16 
*/
public class App {
	public static void main(String[] args) {
		SqlSession sqlSession=new SqlSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		 User user = mapper.getUserById("TEST1");
		 System.out.println(user);
	}
}
