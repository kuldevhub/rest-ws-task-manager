package com.restws.com.restws.jwt.model;

import java.io.Serializable;
/**
 * JwtRequest
This class is required for storing the username and password we recieve from the client.
 * 
 *
 */
public class JwtRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2381171247878241564L;
	private String userName;
	private String password;
	public JwtRequest(String userName, String password) {
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
