package com.whosinapp.whosinappclient.homepage;

import com.whosinapp.whosinappclient.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity 
implements OnClickListener
{
	HomeActivityController myController = new HomeActivityController(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button logoutButton = (Button)this.findViewById(R.id.button_Home_Logout);
        logoutButton.setClickable(true);
        logoutButton.setOnClickListener(this);
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
		
	}
}
