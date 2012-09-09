package com.whosinapp.whosinappclient.createevent;

import android.content.Intent;

import com.whosinapp.whosinappclient.ServiceGateway;
import com.whosinapp.whosinappclient.adduserstoevent.AddUsersToEventActivity;

public class CreateEventController {

	public CreateEventController(CreateEvent createEvent) {
		myActivity = createEvent;
	}
	CreateEvent myActivity ;
	public void DoCreateEventAndTransitionToAddUsers(String nameOfEvent, String dateAndTime) {
		ServiceGateway gate = new ServiceGateway();
		CreateEventDto dto = new CreateEventDto();

		dto.setName(nameOfEvent);
		dto.setDateAndTime(dateAndTime);

		int eventId = gate.Send(dto);
		//Event should be created.  Flow to AddUsersToEvent.
		Intent transitionToAddUsersToEvent = new Intent(this.myActivity,AddUsersToEventActivity.class);
		transitionToAddUsersToEvent.putExtra("eventId", eventId);
		this.myActivity.startActivity(transitionToAddUsersToEvent);
	}

}
