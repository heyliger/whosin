package com.whosinapp.whosinappclient.logout;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.ServiceGateway;
import com.whosinapp.whosinappclient.Login.LoginActivity;
import com.whosinapp.whosinappclient.Login.LoginActivityController;
import com.whosinapp.whosinappclient.R.layout;
import com.whosinapp.whosinappclient.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class LogoutActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        ServiceGateway gate = new ServiceGateway();
        LogoutRequestDto logoutMsg = new LogoutRequestDto();
        logoutMsg.setToken(LoginActivityController.GoodLoginToken);
        try {
			gate.Send(logoutMsg);
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
        Intent backToLogin = new Intent(this,LoginActivity.class);
        LoginActivityController.GoodLoginToken = "";
        this.startActivity(backToLogin);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_logout, menu);
        return true;
    }
}
