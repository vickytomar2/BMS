package com.book.beans;

public class User {
    private String name;
    private String email;
    private boolean isadmin;
    private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getisadmin() {
		return isadmin;
	}
	public void setadmin(boolean isAdmin) {
		this.isadmin = isAdmin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
