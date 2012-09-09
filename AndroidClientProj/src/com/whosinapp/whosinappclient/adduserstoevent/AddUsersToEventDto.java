package com.whosinapp.whosinappclient.adduserstoevent;

import java.util.ArrayList;

public class AddUsersToEventDto {

	private int _eventId;
	
	private ArrayList<Integer> _userIds = new ArrayList<Integer>();

	public int getEventId() {
		return _eventId;
	}

	public void setEventId(int eventId) {
		_eventId = eventId;
	}

	public ArrayList<Integer> getUserIds() {
		return _userIds;
	}

	public void setUserIds(ArrayList<Integer> userIds) {
		_userIds = userIds;
	}
	
}
