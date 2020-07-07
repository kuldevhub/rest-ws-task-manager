package com.restws.com.restws.ui.model.vo.auth;

import java.util.List;

public class LoginVO {

	private String userName;
	private String password;
	private String token;
	private List<String> roles;

	public LoginVO(String userName, String password, String token, List<String> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.token = token;
		this.roles = roles;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public LoginVO(String userName, String password, String token) {
		super();
		this.userName = userName;
		this.password = password;
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LoginVO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
