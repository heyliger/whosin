package com.whosinapp.whosinappclient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.whosinapp.whosinappclient.Login.MainActivity;
import com.whosinapp.whosinappclient.Login.MainActivityController;

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
        try {
			gate.Send(logoutMsg);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Intent backToLogin = new Intent(this,MainActivity.class);
        MainActivityController.GoodLoginToken = "";
        this.startActivity(backToLogin);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_logout, menu);
        return true;
    }
}
