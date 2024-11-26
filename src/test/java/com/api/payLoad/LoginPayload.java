package com.api.payLoad;

import java.io.IOException;

import com.api.utilities.JsonReader;

public class LoginPayload {
	
	String userLoginEmailId;
	String password;
	private static String token;
	//public static String ReqBody;
	
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
	
}
