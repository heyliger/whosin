package com.whosinapp.whosinappclient.createevent;

import java.util.Date;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.R.layout;
import com.whosinapp.whosinappclient.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class CreateEvent extends Activity
implements OnClickListener
{
	CreateEventController myController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        myController = new CreateEventController(this);
        Button butt = (Button)this.findViewById(R.id.button_CreateEvent_AddUsersTransition);
        butt.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_create_event, menu);
        return true;
    }

	public void onClick(View arg0) {
	if (arg0.getId() == R.id.button_CreateEvent_AddUsersTransition)
	{
		//They clicked add users.  They want to go to the add users activity.
		//First, lets create their event.
		String nameOfEvent = ((EditText)this.findViewById(R.id.editText_CreateEvent_Name)).getText().toString();
		DatePicker theDayOf = (DatePicker)this.findViewById(R.id.datePicker_EventCreation_DatePicker);
		int year = theDayOf.getYear();
		int month = theDayOf.getMonth();
		int day = theDayOf.getDayOfMonth();
		TimePicker timeOf = (TimePicker)this.findViewById(R.id.timePicker_EventCreation_TimePicker);
		int hour = timeOf.getCurrentHour();
		int minute=timeOf.getCurrentMinute();
		myController.DoCreateEventAndTransitionToAddUsers(nameOfEvent,year,month,day,hour,minute);
		
	}
	}
}
