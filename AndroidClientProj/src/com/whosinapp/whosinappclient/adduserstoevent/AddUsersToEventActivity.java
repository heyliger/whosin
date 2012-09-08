package com.whosinapp.whosinappclient.adduserstoevent;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.R.layout;
import com.whosinapp.whosinappclient.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AddUsersToEventActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users_to_event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_users_to_event, menu);
        return true;
    }
}
