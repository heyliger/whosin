package com.whosinapp.whosinappclient.models;

public class User implements IEntity{

	private String _email;
	private String _firstName;
	private String _lastName;
	private long _id;
	
	public void setId(long id) {
		_id = id;		
	}
	public long getId() {		
		return _id;
	}
	public String getEmail() {
		return _email;
	}
	public void setEmail(String email) {
		_email = email;
	}
	public String getLastName() {
		return _lastName;
	}
	public void setLastName(String _lastName) {
		this._lastName = _lastName;
	}
	public String getFirstName() {
		return _firstName;
	}
	public void setFirstName(String _firstName) {
		this._firstName = _firstName;
	}
	
	
}
