package com.jack.batis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Stack;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2019年1月6日 下午5:30:57 
*/
public class ConnectionPool {
	private String driver="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/medicalcare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	private String username="root";
	private String password="123456";
	private Stack<Connection> stack;
	private static ConnectionPool singleton;
	
	static{
		singleton=new ConnectionPool();
	}
	
	private ConnectionPool(){
		stack=new Stack<Connection>();
		try {
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(url,username,password);
			stack.push(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return singleton.stack.pop();
	}
}
