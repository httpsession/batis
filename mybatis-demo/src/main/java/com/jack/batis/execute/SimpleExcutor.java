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
import com.jack.app.domain.User;
import com.jack.batis.jdbc.ConnectionPool;

/**
 * @author longjie
 * @mail httpsession@qq.com
 * @date 2018年12月25日 下午4:20:45
 */
public class SimpleExcutor implements Excutor {

	public  List select(String sql, Class beanClz) {
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		Connection connection = ConnectionPool.getConnection();
		User user = null;
		List list=new ArrayList();
		try {
			preparedStatement = connection.prepareStatement(sql);
			set = preparedStatement.executeQuery();
			Object bean =null;
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

	private Object toBean(ResultSet resultSet, Class beanClz) throws Exception {
		if (beanClz == null) {
			throw new RuntimeException("Error! bean class is null");
		}
		ResultSetMetaData metaData = null;
		Object bean = beanClz.newInstance();

		metaData = resultSet.getMetaData();
		int cols = metaData.getColumnCount();
		String columnName = null;
		PropertyDescriptor pd = null;
		for (int i = 1; i <= cols; ++i) {
			columnName=CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, metaData.getColumnName(i));
			pd = new PropertyDescriptor(columnName, beanClz);
			Method wM = pd.getWriteMethod();
			wM.invoke(bean, resultSet.getString(i));
		}
		return bean;
	}
}
