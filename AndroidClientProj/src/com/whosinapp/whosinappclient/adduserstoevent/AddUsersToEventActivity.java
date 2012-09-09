package com.whosinapp.whosinappclient.adduserstoevent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.Login.LoginActivityController;
import com.whosinapp.whosinappclient.adapters.UserAdapter;
import com.whosinapp.whosinappclient.models.User;
import com.whosinapp.whosinappclient.R.layout;
import com.whosinapp.whosinappclient.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class AddUsersToEventActivity extends Activity {

	private EditText _editTextEmailAddress;
	private Button _buttonSearch;
	private TextView _textViewUserNotification;
	private ListView _listViewUsers;
	private Button _buttonAddUsersToEvent;

	private ArrayList<User> _users;
	private UserAdapter _userAdapter;

	AddUsersToEventController _myController = new AddUsersToEventController(
			this);

	private int _eventId = -1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_users_to_event);

		// get the group id that was sent to us in the intent
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			_eventId = extras.getInt("eventId");
		}

		
		_users = new ArrayList<User>();
		_userAdapter = new UserAdapter(this,R.layout.user_row , _users);

		_editTextEmailAddress = (EditText) this
				.findViewById(R.id.editTextEmailAddress);
		_buttonSearch = (Button) this.findViewById(R.id.buttonSearch);
		_textViewUserNotification = (TextView) this
				.findViewById(R.id.textViewUserNotification);
		_listViewUsers = (ListView) this.findViewById(R.id.listViewUsers);
		_buttonAddUsersToEvent = (Button) this
				.findViewById(R.id.buttonAddUsersToEvent);
		
		_listViewUsers.setAdapter(_userAdapter);

		_buttonSearch.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				try {
					User user = _myController
							.searchForUserByEmail(_editTextEmailAddress
									.getText());

					if (user == null) {
						// Boo, they're not in our system
						setUserNotification("Send them an invite yo!");

					} else {
						// Sweet we found our friend
						setUserNotification("Yay, we found them");
						_users.add(user);
						
						_userAdapter.notifyDataSetChanged();
					}

				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		_buttonAddUsersToEvent.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				try {

					ArrayList<Integer> ids = new ArrayList<Integer>();

					for (User user : _users) {
						ids.add((int) user.getId());
					}

					_myController.addUsersToEvent(_eventId, ids);
					
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_add_users_to_event, menu);
		return true;
	}

	public TextView getTextViewUserNotification() {
		return _textViewUserNotification;
	}

	public void setUserNotification(String notification) {
		_textViewUserNotification.setText(notification);
	}
}
