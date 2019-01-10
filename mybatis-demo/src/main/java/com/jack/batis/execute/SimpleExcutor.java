package com.jack.batis.execute;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.CaseFormat;
import com.jack.batis.jdbc.ConnectionPool;

/**
 * SQL执行器
 * @author longjie
 * @date 2018年12月25日 下午4:20:45
 */
public class SimpleExcutor implements Excutor {

	/**
	 * 查询操作方法
	 * 
	 */
	/**
	 * @param sql 将要执行的SQL语句
	 * @param beanClz 结果集要映射成的javaBean类
	 */
	public  <T> List<T> select(String sql, Class<T> beanClz) {
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		Connection connection = ConnectionPool.getConnection();
		List<T> list=new ArrayList<T>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			set = preparedStatement.executeQuery();
			T bean =null;
			while (set.next()) {
				bean= toBean(set,beanClz);
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int delete(String sql) {
		return execute(sql);
	}

	public int update(String sql) {
		return execute(sql);
	}

	public int insert(String sql) {
		return execute(sql);
	}
 
	private int execute(String sql) {
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionPool.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			int count = preparedStatement.executeUpdate();
			preparedStatement.close();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	   *   将查询的结果集转化成javaBean
	 * @param resultSet
	 * @param beanClz
	 * @return 
	 * @return
	 * @throws Exception
	 */
	private  <T>  T toBean(ResultSet resultSet,  Class<T> beanClz) throws Exception {
		if (beanClz == null) {
			throw new RuntimeException("Error! bean class is null");
		}
		ResultSetMetaData metaData = null;
		T bean = beanClz.newInstance();

		metaData = resultSet.getMetaData();
		int cols = metaData.getColumnCount();
		String columnName = null;
		PropertyDescriptor pd = null;
		//遍历列
		for (int i = 1; i <= cols; ++i) {
			//将列名转换成驼峰类型命名
			columnName=CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, metaData.getColumnName(i));
			pd = new PropertyDescriptor(columnName, beanClz);
			Method method = pd.getWriteMethod();
			//将查询出来的值赋值到bean属性中
			method.invoke(bean, resultSet.getString(i));
		}
		return bean;
	}
}
