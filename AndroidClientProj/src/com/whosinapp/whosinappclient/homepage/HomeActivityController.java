package com.whosinapp.whosinappclient.homepage;

import com.whosinapp.whosinappclient.createevent.CreateEvent;
import com.whosinapp.whosinappclient.creategroup.CreateGroupActivity;
import com.whosinapp.whosinappclient.logout.LogoutActivity;

import android.content.Intent;

public class HomeActivityController {

	public HomeActivityController(HomeActivity homeActivity) {
		myActivity = homeActivity;
	}
	HomeActivity myActivity;
	public void DoLogout() {
		Intent goDoLogoutActivity = new Intent(myActivity, LogoutActivity.class);
		myActivity.startActivity(goDoLogoutActivity);
	}
	public void DoCreateEvent() {
		Intent goDoCreateEventActivity = new Intent(myActivity, CreateEvent.class);
		myActivity.startActivity(goDoCreateEventActivity);
	}
	public void DoCreateGroup() {
		Intent goDoCreateGroupActivity = new Intent(myActivity, CreateGroupActivity.class);
		myActivity.startActivity(goDoCreateGroupActivity);
	}

}
