package com.whosinapp.whosinappclient.homepage;

import com.whosinapp.whosinappclient.createevent.CreateEvent;
import com.whosinapp.whosinappclient.creategroup.CreateGroupActivity;
import com.whosinapp.whosinappclient.getalleventsforuser.ShowAllEventsForUserActivity;
import com.whosinapp.whosinappclient.getgroupsforuser.GetGroupsForUserActivity;
import com.whosinapp.whosinappclient.getusersforgroup.GetUsersForGroupActivity;
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
	public void DoGetUsersForGroup(){
		Intent goDoCreateGroupActivity = new Intent(myActivity, GetUsersForGroupActivity.class);
			myActivity.startActivity(goDoCreateGroupActivity);
	}
	public void DoGetGroupsForUser(){
		Intent goDoCreateGroupActivity = new Intent(myActivity, GetGroupsForUserActivity.class);
			myActivity.startActivity(goDoCreateGroupActivity);
	}
	public void DoGetAllEventsForUser() {
		Intent goGetAllEvents = new Intent(myActivity, ShowAllEventsForUserActivity.class);
		myActivity.startActivity(goGetAllEvents);
		
	}

}
