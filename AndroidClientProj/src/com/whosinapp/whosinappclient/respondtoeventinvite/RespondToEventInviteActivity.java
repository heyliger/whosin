package com.whosinapp.whosinappclient.respondtoeventinvite;

import com.whosinapp.whosinappclient.adapters.EventInviteAdapter;
import com.whosinapp.whosinappclient.models.EventInfoStub;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RespondToEventInviteActivity extends Activity {

	private TextView _eventNameTextView;
	private TextView _dateAndTimeTextView;
	private TextView _descriptionTextView;
	private Button _acceptButton;
	private Button _declineButton;
	
	private RespondToEventInviteController _controller = 
			new RespondToEventInviteController();
	
	private EventInfoStub _event;
	private EventInviteAdapter _eventInviteAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			_event = (EventInfoStub)extras.get("event");
		}
		
		
	}
}
