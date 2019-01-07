package com.jack.batis;

import com.google.common.base.Strings;
import com.jack.batis.core.Configuration;
import com.jack.batis.core.SqlSession;

public class Batis {
	private static SqlSession session;
	public static void init(String mapperPath) {
		if(Strings.isNullOrEmpty(mapperPath)) {
			throw new RuntimeException("Failed to load Batis because mapper path is null!");
		}
		Configuration.mapperScanner(mapperPath);
		session = new SqlSession();
	}
	
	public static <T> T getMapper(Class<T> clazz) {
		return (T) session.getMapper(clazz);
	}
}
