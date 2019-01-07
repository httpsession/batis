package com.jack.app.dao;

import com.jack.app.domain.User;
import com.jack.batis.annotation.Delete;
import com.jack.batis.annotation.Mapper;
import com.jack.batis.annotation.Select;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午3:02:20 
*/
@Mapper
public interface UserDao {
	@Select("select * from mall_user")
	public User getUserById(String userId);
	
	@Delete("delete from sys_user where user_id= #{userId}")
	public int deleteUserById(String userId);
}
