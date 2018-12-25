package com.jack.app.dao;

import com.jack.app.domain.User;
import com.jack.batis.anno.Mapper;
import com.jack.batis.anno.Select;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午3:02:20 
*/
@Mapper
public interface UserDao {
	@Select("select * from mall_user")
	public User getUserById(String userId);
}
