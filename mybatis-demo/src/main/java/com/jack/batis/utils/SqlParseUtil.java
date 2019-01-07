package com.jack.batis.utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Strings;

public class SqlParseUtil {
	static String replaceString = "\\#\\{[ a-zA-Z_0-9\u4E00-\u9FA5]*\\}";

	/**
	 * 静态参数 初始化
	 * @param sql
	 * @param params
	 * @return
	 */
	public static String parse(String sql, Map<String, String> params) {
		if(Strings.isNullOrEmpty(sql)) {
			return null;
		}
		Pattern p = Pattern.compile(replaceString);
		Matcher m = p.matcher(sql);
		StringBuffer buf = new StringBuffer();
		while (m.find()) {
			String param = m.group();
			String pn = param.substring(2, param.length() - 1);
			String nfParam = params.get(pn.trim());

			if (nfParam == null) {
				throw new RuntimeException("param: " + pn + " 没有定义");
			}
			m.appendReplacement(buf, nfParam);
		}
		m.appendTail(buf);
		return buf.toString();
	}
}
