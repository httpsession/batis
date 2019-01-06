package com.jack.app;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.jack.app.dao.UserDao;
import com.jack.app.domain.User;
import com.jack.batis.core.Configuration;
import com.jack.batis.core.SqlSession;
import com.jack.batis.utils.ActionAndSql;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2019年1月6日 下午4:57:50 
*/
public class App {
	public static void main(String[] args) {
		Configuration.mapperScanner("com.jack.app.dao");
		Map<String, ActionAndSql> map = Configuration.statementMap;
		System.out.println(JSON.toJSONString(map));
	}
	
	/**
	 public static void main(String[] args) {
		SqlSession sqlSession = new SqlSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		User user = mapper.getUserById("TEST1");
		System.out.println(user);
	}
	 */
}
