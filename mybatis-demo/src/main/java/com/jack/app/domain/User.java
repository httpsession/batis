package com.jack.app.domain;
/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年11月24日 下午8:23:43 
*/
public class User {
	private String userId;
	private String userPassword;
	private String userMail;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + ", userMail=" + userMail + "]";
	}
}
