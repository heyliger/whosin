package com.whosinapp.whosinappclient.adduserstoevent;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.text.Editable;

import com.whosinapp.whosinappclient.ServiceGateway;

public class AddUsersToEventController {
	
	AddUsersToEventActivity _myActivity;

	public AddUsersToEventController(AddUsersToEventActivity mainActivity) {
		_myActivity = mainActivity;
	}

	public void searchForUserByEmail(Editable emailAddress)
			throws ClientProtocolException, IOException {
		
		String email = emailAddress.toString();
		
		SearchForUserByEmailDto myDto = new SearchForUserByEmailDto();
		myDto.setEmail(email);
		
		ServiceGateway theGate = new ServiceGateway();
		
		int userID = theGate.Send(myDto);
		if (userID > 0) {
			// Sweet we found our friend
			_myActivity.setUserNotification("Yay, we found them");

		} else {
			// Boo, they're not in our system
			_myActivity.setUserNotification("Send them an invite yo!");
		}

	}

}
