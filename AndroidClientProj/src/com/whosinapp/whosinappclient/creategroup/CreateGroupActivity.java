package com.whosinapp.whosinappclient.creategroup;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.R.layout;
import com.whosinapp.whosinappclient.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CreateGroupActivity extends Activity 
implements OnClickListener
{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        myController = new CreateGroupActivityController(this);
        Button transition = (Button)this.findViewById(R.id.button_CreateGroup_CreateGroupAndTransitionToAddUsers);
        transition.setOnClickListener(this);
    }
    CreateGroupActivityController myController;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_create_group, menu);
        return true;
    }

	public void onClick(View arg0) {
		String groupName = ((EditText)this.findViewById(R.id.editText_CreateGroup_GroupName)).getText().toString();
		this.myController.CreateGroupAndTransitionToAddUsers(groupName);
		
	}
}
