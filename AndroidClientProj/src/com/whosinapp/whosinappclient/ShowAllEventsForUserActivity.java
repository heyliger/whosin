package com.whosinapp.whosinappclient;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ShowAllEventsForUserActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_events_for_user);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_show_all_events_for_user, menu);
        return true;
    }
}
