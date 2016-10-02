package com.example;

public class Login {
	private long loginID;
	private String user, password;
	
	public Login(long loginID, String user, String password){
		this.loginID=loginID;
		this.user=user;
		this.password=password;
	}
	
	public long getLoginID(){
		return this.loginID;
	}
	public void setLoginID(long login){
		this.loginID=loginID;
	}
	
	public String getUser(){
		return this.user;
	}
	public void setUser(String user){
		this.user=user;
	}
	
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
}
