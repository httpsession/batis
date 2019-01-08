package com.jack.batis.execute;

import java.util.List;

/** 
* SQL执行器 
* 
* @author	longjie 
* @date 	2018年12月25日 下午4:16:46 
*/
public interface Excutor {
	/**
	   *   查找方法
	 * @param sql  将要执行的SQL语句
	 * @param beanClz  查询结果要映射的javaBean类
	 * @return
	 */
	public  <T> List<T> select(String sql, Class<T> beanClz) ;
	
	/**
	   *  执行删除
	 * @param sql 将要执行的SQL语句
	 * @return
	 */
	public int delete(String sql);
	
	
	/**
	   *   执行更新
	 * @param sql 将要执行的SQL语句
	 * @return
	 */
	public int update(String sql);
	
	/**
	   *   执行插入
	 * @param sql 将要执行的SQL语句
	 * @return
	 */
	public int insert(String sql);
}
