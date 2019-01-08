package com.jack.batis.execute;

import java.util.List;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午4:16:46 
*/
public interface Excutor {
	public  List select(String sql, Class beanClz) ;
	
	public int delete(String sql);
	
	public int update(String sql);
	
	public int insert(String sql);
}
