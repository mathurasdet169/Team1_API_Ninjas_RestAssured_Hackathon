package com.api.payLoad;

public class LoginPayload {
	
	String userLoginEmailId;
	String password;
	int statusCode;
	private static String token;
	
	public String getUserLoginEmailId() {
		return userLoginEmailId;
	}
	public void setUserLoginEmailId(String userLoginEmailId) {
		this.userLoginEmailId = userLoginEmailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public int getstatusCode() {
		return statusCode;
	}
	public void setstatusCode(int statusCode) {
		this.statusCode=statusCode;
	}

}
