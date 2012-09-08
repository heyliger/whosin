package com.whosinapp.whosinappclient.createevent;

import android.content.Intent;

import com.whosinapp.whosinappclient.ServiceGateway;
import com.whosinapp.whosinappclient.adduserstoevent.AddUsersToEventActivity;

public class CreateEventController {

	public CreateEventController(CreateEvent createEvent) {
		myActivity = createEvent;
	}
	CreateEvent myActivity ;
	public void DoCreateEventAndTransitionToAddUsers(String nameOfEvent,
			int year, int month, int day, int hour, int minute) {
		ServiceGateway gate = new ServiceGateway();
		CreateEventDto dto = new CreateEventDto();
		dto.setDay(day);
		dto.setHour(hour);
		dto.setMinute(minute);
		dto.setMonth(month);
		dto.setName(nameOfEvent);
		dto.setYear(year);
		gate.Send(dto);
		//Event should be created.  Flow to AddUsersToEvent.
		Intent transitionToAddUsersToEvent = new Intent(this.myActivity,AddUsersToEventActivity.class);
		this.myActivity.startActivity(transitionToAddUsersToEvent);
	}

}
