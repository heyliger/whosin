package com.whosinapp.whosinappclient.Login;

import java.io.IOException;
import com.google.android.gcm.GCMRegistrar;

import org.apache.http.client.ClientProtocolException;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.NewUser.NewUserActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity
implements android.view.View.OnClickListener
{
	LoginActivityController myController = new LoginActivityController(this);
	Button doLogin ;
	static final String TAG = LoginActivity.class.getSimpleName();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doLogin = (Button) this.findViewById( R.id.button_do_login);
        doLogin.setClickable(true);
        doLogin.setOnClickListener((android.view.View.OnClickListener) this);
        Button newUser = (Button)this.findViewById(R.id.button_New_User);
        newUser.setOnClickListener((android.view.View.OnClickListener) this);
        
        /*
         * The checkDevice() method verifies that the device supports GCM and throws 
         * an exception if it does not (for instance, if it is an emulator that does 
         * not contain the Google APIs). Similarly, the checkManifest() method verifies 
         * that the application manifest contains meets all the requirements described 
         * in Writing the Android Application (this method is only necessary 
         * when you are developing the application; once the application is ready 
         * to be published, you can remove it).
         * Once the sanity checks are done, the device calls GCMRegsistrar.register() 
         * to register the device, passing the SENDER_ID you got when you signed up for GCM. 
         * But since the GCMRegistrar singleton keeps track of the registration ID upon 
         * the arrival of registration intents, you can call GCMRegistrar.getRegistrationId() 
         * first to check if the device is already registered.
         */
        
        //try
        {
	        GCMRegistrar.checkDevice(this);
	        GCMRegistrar.checkManifest(this);
	        final String regId = GCMRegistrar.getRegistrationId(this);
	        if (regId.equals("")) {
	          GCMRegistrar.register(this, "1068757721296");
	        } else {
	          Log.v(TAG, "Already registered");
	        }
        }
//        catch (Exception ex)
//        {
//        	Log.v(TAG, ex.toString());
//        }
        
        
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

