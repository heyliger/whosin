package com.whosinapp.whosinappclient.createevent;

public class CreateEventDto {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private String name;
	
	public int getYear()
	{
		return year;
	}
	public int getMonth()
	{
		return month;
	}
	public int getDay()
	{
		return day;
	}
	public int getHour()
	{
		return hour;
	}
	public int getMinute()
	{
		return minute;
	}
	public String getName()
	{
		return name;
	}
	public void setYear(int yr)
	{
		year = yr;
	}
	public void setMonth(int mn)
	{
		month = mn;
	}
	public void setDay(int dy)
	{
		day = dy;
	}
	public void setHour(int hr)
	{
		hour = hr;
	}
	public void setMinute(int mn)
	{
		minute = mn;
	}
	public void setName(String nameCandidate)
	{
		name = nameCandidate;
	}
}
