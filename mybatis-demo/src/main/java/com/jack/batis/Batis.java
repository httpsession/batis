package com.jack.batis;

import com.google.common.base.Strings;
import com.jack.batis.core.Configuration;
import com.jack.batis.core.SqlSession;

public class Batis {
	private static SqlSession session;
	
	/**
	 * batis初始化
	 * 
	 * @param mapperPath  mapper所在的包路径
	 */
	public static void init(String mapperPath) {
		if(Strings.isNullOrEmpty(mapperPath)) {
			throw new RuntimeException("Failed to init Batis because mapper path is null!");
		}
		Configuration.mapperScanner(mapperPath);
		session = new SqlSession();
	}
	
	public static <T> T getMapper(Class<T> clazz) {
		return (T) session.getMapper(clazz);
	}
}
