package com.jack.batis.excute;
/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午4:16:46 
*/
public interface Excutor {
	public <T> T query(String statement,Object parameter);
}
