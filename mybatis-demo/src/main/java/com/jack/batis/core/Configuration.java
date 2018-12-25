package com.jack.batis.core;

import java.util.HashMap;
import java.util.Map;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午3:53:23 
*/
public class Configuration {
	public static Map<String,String> mapStateMent=new HashMap<String,String>();
	//								com.jack.app.dao.UserDa
	public static String namespace="com.jack.app.dao.UserDao";
	
	public void scanner(){
		
	}
	static{
		//模拟xml中的id与sql语句
		mapStateMent.put("getUserById", "select * from mall_user where user_id = ?");
	}

}
