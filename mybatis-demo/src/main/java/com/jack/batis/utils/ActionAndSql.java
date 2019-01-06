package com.jack.batis.utils;
/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2019年1月6日 下午3:53:56 
*/
public class ActionAndSql {
	private int action;// action flag
	private String sql;//sql statements
	
	public ActionAndSql(int action,String sql){
		if(!(action==Action.select||action==Action.update||action==Action.insert||action==Action.delete)){
			throw new RuntimeException("The value of operate is invalid!");
		}
		if(sql==null){
			throw new RuntimeException("The sql is no allow be null!");
		}
		this.action=action;
		this.sql=sql;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
}
