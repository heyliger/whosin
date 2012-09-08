package com.whosinapp.whosinappclient.Login;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.NewUser.NewUserActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity
implements android.view.View.OnClickListener
{
	LoginActivityController myController = new LoginActivityController(this);
	Button doLogin ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doLogin = (Button) this.findViewById( R.id.button_do_login);
        doLogin.setClickable(true);
        doLogin.setOnClickListener((android.view.View.OnClickListener) this);
        Button newUser = (Button)this.findViewById(R.id.button_New_User);
        newUser.setOnClickListener((android.view.View.OnClickListener) this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


	public void onClick(View v) {
		if (v.getId() == R.id.button_do_login)
		{
			EditText userName = (EditText) this.findViewById(R.id.editText_username);
			EditText passWord = (EditText) this.findViewById(R.id.editText_password);
		
			try {
				myController.DoLogin(userName.getText(),passWord.getText());
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (v.getId() == R.id.button_New_User)
		{
			Intent newUserIntent = new Intent(this,NewUserActivity.class);
			this.startActivity(newUserIntent);
		}
		
	}
}

