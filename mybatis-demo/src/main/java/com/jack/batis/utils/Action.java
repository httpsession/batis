package com.jack.batis.utils;


/** 
* @author	longjie 
* @date 	2019年1月6日 下午4:13:09 
* 
*   SQL执行的操作类型
* 
*/
public interface Action {
	final int select=1;
	final int update=2;
	final int insert=3;
	final int delete=4;
}
