package com.whosinapp.whosinappclient.createevent;

import java.text.SimpleDateFormat;
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

public class CreateEvent extends Activity implements OnClickListener {
	CreateEventController myController;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_event);
		myController = new CreateEventController(this);
		Button butt = (Button) this
				.findViewById(R.id.button_CreateEvent_AddUsersTransition);
		butt.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_create_event, menu);
		return true;
	}

	public void onClick(View arg0) {
		if (arg0.getId() == R.id.button_CreateEvent_AddUsersTransition) {

			// Format date to YYYY-MM-DDThh:mmZ

			// They clicked add users. They want to go to the add users
			// activity.
			// First, lets create their event.
			String nameOfEvent = ((EditText) this
					.findViewById(R.id.editText_CreateEvent_Name)).getText()
					.toString();
			DatePicker datePicker = (DatePicker) this
					.findViewById(R.id.datePicker_EventCreation_DatePicker);
			TimePicker timePicker = (TimePicker) this
					.findViewById(R.id.timePicker_EventCreation_TimePicker);

			Date eventDate = new Date(datePicker.getYear() - 1900,
					datePicker.getMonth(), datePicker.getDayOfMonth());
			eventDate.setHours(timePicker.getCurrentHour());
			eventDate.setMinutes(timePicker.getCurrentMinute());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
			String dateString = sdf.format(eventDate);

			myController.DoCreateEventAndTransitionToAddUsers(nameOfEvent,
					dateString);

		}
	}
}
