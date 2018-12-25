package com.jack.batis.excute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jack.app.domain.User;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年12月25日 下午4:20:45 
*/
public class SimpleExcutor implements Excutor {

	public <T> T query(String sql, Object parameter) {
		
		PreparedStatement preparedStatement=null;
		Connection connection=getConnection();
		User user=new User();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,parameter.toString());
			ResultSet set = preparedStatement.executeQuery();
			while(set.next()){
				user.setUserId(set.getString("user_id"));
				user.setUserMail(set.getString("user_mail"));
				user.setUserPassword(set.getString("user_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (T)user;
	}
	
	private Connection getConnection(){
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String username="root";
		String password="123456";
		Connection connection=null;
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	//https://blog.csdn.net/worn_xiao/article/details/78888640
	

}
