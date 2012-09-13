package com.whosinapp.whosinappclient.homepage;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.google.android.gcm.GCMRegistrar;
import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.ServiceGateway;
import com.whosinapp.whosinappclient.registerdevice.RegisterDeviceDto;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity 
implements OnClickListener
{
	private static final String TAG = HomeActivity.class.getSimpleName();
	HomeActivityController myController = new HomeActivityController(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button logoutButton = (Button)this.findViewById(R.id.button_Home_Logout);
        logoutButton.setClickable(true);
        logoutButton.setOnClickListener(this);
        
        myController.RegisterDevice(this, TAG);
        
        try
        {
        Button createEventButton = (Button)this.findViewById(R.id.button_home_CreateNewEvent);
        createEventButton.setOnClickListener(this);
        }
        catch (Exception err)
        {
        	Log.e("CreateEventButton",err.toString());
        }
        try     
        {
        Button createGroupButton = (Button)this.findViewById(R.id.button_Home_CreateGroup);
        createGroupButton.setOnClickListener(this);
        }
        catch (Exception err)
        {
        	Log.e("CreateGroupButton",err.toString());
        }
        try
        {
        	Button getUsersForGroupButton = (Button)this.findViewById(R.id.button_Home_GetUsersForGroup);
        	getUsersForGroupButton.setOnClickListener(this);
        }
        catch (Exception err)
        {
        	Log.e("GetUsersForGroupButton", err.toString());
        }
        try
        {
        	Button getGroupsForUserButton = (Button)this.findViewById(R.id.button_Home_GetGroupsForUser);
        	getGroupsForUserButton.setOnClickListener(this);
        }
        catch (Exception err)
        {
        	Log.e("GetUsersForGroupButton", err.toString());
        }
        try
        {
        	Button getAllEventsForUserButton = (Button)this.findViewById(R.id.button_home_AllEventsForUser);
        	getAllEventsForUserButton.setOnClickListener(this);
        }
        catch (Exception err)
        {
        	Log.e("GetAllEventsForUserButton",err.toString());
        }
        
        		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }

	public void onClick(View arg0) {
		if (arg0.getId()==R.id.button_Home_Logout)
		{
			//Do Logout
			myController.DoLogout();
		}
		if (arg0.getId()==R.id.button_home_CreateNewEvent)
		{
			//Add event
			myController.DoCreateEvent();
		}
		if (arg0.getId()==R.id.button_Home_CreateGroup)
		{
			myController.DoCreateGroup();
		}
		if(arg0.getId()==R.id.button_Home_GetUsersForGroup)
		{
			myController.DoGetUsersForGroup();
		}
		if(arg0.getId()==R.id.button_Home_GetGroupsForUser)
		{
			myController.DoGetGroupsForUser();
		}
		if (arg0.getId()==R.id.button_home_AllEventsForUser)
		{
			myController.DoGetAllEventsForUser();
		}
	}
}
