package com.whosinapp.whosinappclient.createevent;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.R.layout;
import com.whosinapp.whosinappclient.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class CreateEvent extends Activity
implements OnClickListener
{
	CreateEventController myController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        myController = new CreateEventController(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_create_event, menu);
        return true;
    }

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
