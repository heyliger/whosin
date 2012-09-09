package com.whosinapp.whosinappclient.adduserstoevent;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.Login.LoginActivityController;
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

	EditText _editTextEmailAddress;
	Button _buttonSearch;
	private TextView _textViewUserNotification;
	ListView _listViewUsers;
	
	AddUsersToEventController _myController = new AddUsersToEventController(this);
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users_to_event);
        
        
        
        int groupId = (Integer)savedInstanceState.get("groupId");
        
        _editTextEmailAddress = (EditText)this.findViewById(R.id.editTextEmailAddress);
        _buttonSearch = (Button)this.findViewById(R.id.buttonSearch);
        _textViewUserNotification = (TextView)this.findViewById(R.id.textViewUserNotification);
        _listViewUsers = (ListView)this.findViewById(R.id.listViewUsers);
        
        _buttonSearch.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				try {
					_myController.searchForUserByEmail(_editTextEmailAddress.getText());
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
