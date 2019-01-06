package com.jack.batis.execute;
/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午4:16:46 
*/
public interface Excutor {
	public <T> T select(String sql);
	
	public int delete(String sql);
	
	public int update(String sql);
	
	public int insert(String sql);
}
