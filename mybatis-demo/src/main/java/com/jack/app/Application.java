package com.jack.app;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jack.app.domain.User;
import com.jack.app.service.UserService;
import com.jack.batis.Batis;
import com.jack.batis.annotation.Autowired;
import com.jack.batis.beans.DefaultBeanFactory;

public class Application {
	
	@Autowired
	static UserService userService;
	
	public static void main(String[] args) {
		init();
		List<User> result = userService.getUserById("6");
		String json = JSONObject.toJSONString(result);
		System.out.println(json);
	}
	
	public static void init() {
		try {
			Batis.init("com.jack.app.dao");
			DefaultBeanFactory.init("com.jack.app");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
