package com.whosinapp.whosinappclient;

public class LoginRequestDto {
	private String userName;
	private String passWord;
	
	public String getPassword()
	{
		return passWord;
	}
	
	public void setPassword(String value)
	{
		passWord = value;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String value)
	{
		userName = value;
	}
} 
