package com.jack.app.service;

import java.util.List;

import com.google.common.base.Strings;
import com.jack.app.dao.UserDao;
import com.jack.app.domain.User;
import com.jack.batis.annotation.Autowired;
import com.jack.batis.annotation.Service;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<User> getUserById(String userId){
		if(Strings.isNullOrEmpty(userId)) {
			throw new RuntimeException("param userId is not allow be null or empty!");
		}
		return userDao.getUserById(userId);
	}
}
