package com.whosinapp.whosinappclient.getalleventsforuser;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.whosinapp.whosinappclient.ServiceGateway;
import com.whosinapp.whosinappclient.models.EventInfoStub;

public class ShowAllEventsForUserActivityController {

	public ShowAllEventsForUserActivityController(
			ShowAllEventsForUserActivity showAllEventsForUserActivity) {
		// TODO Auto-generated constructor stub
	}

	public Iterable<EventInfoStub> RetrieveAllEventsForUser() {
		ServiceGateway myGate = new ServiceGateway();
		try {
			Iterable<EventInfoStub> myEvents = myGate.Send(new GetAllEventsForUserDto());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
