package com.jack.batis.utils;

import com.google.common.base.Strings;

public class MethodUtil {
	/**
	   *   提取方法返回类型的最小粒子
	 * eg: 如果genericReturnType为java.util.List<T>，则返回"T" 
	 * @param genericReturnType
	 * @return
	 */
	public static String extract(String genericReturnType) {
		if(!Strings.isNullOrEmpty(genericReturnType)) {
			int start=genericReturnType.indexOf("<");
			int end=genericReturnType.indexOf(">");
			if(start>-1&&start<end) {
				return genericReturnType.substring(start+1, end);
			}
		}
		return null;
	}
}
