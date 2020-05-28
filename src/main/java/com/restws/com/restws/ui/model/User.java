package com.restws.com.restws.ui.model;

//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Setter;
//import lombok.ToString;

//@AllArgsConstructor
//@Accessors(fluent=true) @Getter
//@ToString
//@EqualsAndHashCode
//@Setter
public class User {

	public User(String firstName, String lastName, String email, String userId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userId = userId;
	}
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getUserId() {
		return userId;
	}
	private String lastName;
	private String email;
	private String userId;
	
	
}
