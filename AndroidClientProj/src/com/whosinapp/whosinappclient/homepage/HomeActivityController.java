package com.whosinapp.whosinappclient.homepage;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.google.android.gcm.GCMRegistrar;
import com.whosinapp.whosinappclient.GCMIntentService;
import com.whosinapp.whosinappclient.ServiceGateway;
import com.whosinapp.whosinappclient.createevent.CreateEvent;
import com.whosinapp.whosinappclient.creategroup.CreateGroupActivity;
import com.whosinapp.whosinappclient.getalleventsforuser.ShowAllEventsForUserActivity;
import com.whosinapp.whosinappclient.getgroupsforuser.GetGroupsForUserActivity;
import com.whosinapp.whosinappclient.getusersforgroup.GetUsersForGroupActivity;
import com.whosinapp.whosinappclient.logout.LogoutActivity;
import com.whosinapp.whosinappclient.registerdevice.RegisterDeviceDto;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

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
	public void RegisterDevice(Context context, String tag) {
		
		/*
         * The checkDevice() method verifies that the device supports GCM and throws 
         * an exception if it does not (for instance, if it is an emulator that does 
         * not contain the Google APIs). Similarly, the checkManifest() method verifies 
         * that the application manifest contains meets all the requirements described 
         * in Writing the Android Application (this method is only necessary 
         * when you are developing the application; once the application is ready 
         * to be published, you can remove it).
         * Once the sanity checks are done, the device calls GCMRegsistrar.register() 
         * to register the device, passing the SENDER_ID you got when you signed up for GCM. 
         * But since the GCMRegistrar singleton keeps track of the registration ID upon 
         * the arrival of registration intents, you can call GCMRegistrar.getRegistrationId() 
         * first to check if the device is already registered.
         */
		
		// Now that we are logged in,
        // make sure we register our device
        GCMRegistrar.checkDevice(context);
        GCMRegistrar.checkManifest(context);
        final String regId = GCMRegistrar.getRegistrationId(context);
        if (regId.equals("")) {
        	// This is the first time the device has 
        	// run the app.  Register for push notifications
          GCMRegistrar.register(context, "1068757721296");
          Log.v(tag, "Newly registered");
        } else {
        	//GCMRegistrar.unregister(context);
        	// This shouldn't be necessary because if we already
        	// have a registration id, then the server should already
        	// know about it.  However, it doesn't hurt to do this
        	// and addresses the case in which the device was successfully 
        	// registered with the GCM service, but our server never 
        	// got the notification.
        	GCMIntentService.sendRegistrationToServer(regId);
          Log.v(tag, "Already registered");
        }
	}

}
