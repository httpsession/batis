package com.jack.app.dao;

import java.util.List;

import com.jack.app.domain.User;
import com.jack.batis.annotation.Mapper;
import com.jack.batis.annotation.sql.Delete;
import com.jack.batis.annotation.sql.Select;

/** 
* @author	longjie 
* @date 	2018年12月25日 下午3:02:20 
*/
@Mapper
public interface UserDao {
	@Select("select * from sys_user where user_id=#{userId}")
	public List<User> getUserById(String userId);
	
	@Delete("delete from sys_user where user_id= #{userId}")
	public int deleteUserById(String userId);
}
