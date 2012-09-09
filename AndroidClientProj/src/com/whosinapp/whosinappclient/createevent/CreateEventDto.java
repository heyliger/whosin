package com.whosinapp.whosinappclient.createevent;

public class CreateEventDto {
	private String _dateAndTime;
	private String _name;
	
	public String getDateAndTime()
	{
		return _dateAndTime;
	}
	public void setDateAndTime(String dateAndTime)
	{
		_dateAndTime = dateAndTime;
	}

	public String getName()
	{
		return _name;
	}

	public void setName(String name)
	{
		_name = name;
	}
}
