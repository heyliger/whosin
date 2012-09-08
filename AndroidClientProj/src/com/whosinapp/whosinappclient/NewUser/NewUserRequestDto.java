package com.whosinapp.whosinappclient.NewUser;

public class NewUserRequestDto {
	private String firstName;
	private String lastName;
	private String passWord;
	private String passWordConfirmation;
	private String emailAddress;
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String value)
	{
		firstName = value;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String value)
	{
		lastName = value;
	}
	public String getPassword()
	{
		return passWord;
	}
	public void setPassword(String value)
	{
		passWord = value;
	}
	public String getPasswordConfirmation()
	{
		return passWordConfirmation;
	}
	public void setPasswordConfirmation(String value)
	{
		passWordConfirmation = value;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public void setEmailAddress(String value)
	{
		emailAddress = value;
	
	}
	
	
}
