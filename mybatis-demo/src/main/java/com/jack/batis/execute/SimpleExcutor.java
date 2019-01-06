package com.jack.batis.execute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jack.app.domain.User;
import com.jack.batis.jdbc.ConnectionPool;

/**
 * @author longjie
 * @mail httpsession@qq.com
 * @date 2018年12月25日 下午4:20:45
 */
public class SimpleExcutor implements Excutor {

	public <T> T select(String sql) {
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		Connection connection = ConnectionPool.getConnection();
		User user=null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			set = preparedStatement.executeQuery();
			user = new User();
			while (set.next()) {
				user.setUserId(set.getString("user_id"));
				user.setUserMail(set.getString("user_mail"));
				user.setUserPassword(set.getString("user_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (T) user;
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

	/*
	 * public <T> T query(String sql, Object parameter) { PreparedStatement
	 * preparedStatement=null; Connection
	 * connection=ConnectionPool.getConnection(); User user=new User(); try {
	 * preparedStatement=connection.prepareStatement(sql);
	 * preparedStatement.setString(1,parameter.toString()); ResultSet set =
	 * preparedStatement.executeQuery(); while(set.next()){
	 * user.setUserId(set.getString("user_id"));
	 * user.setUserMail(set.getString("user_mail"));
	 * user.setUserPassword(set.getString("user_password")); } } catch
	 * (SQLException e) { e.printStackTrace(); } return (T)user; }
	 */
}
