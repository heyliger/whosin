package com.whosinapp.whosinappclient.Login;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.whosinapp.whosinappclient.*;
import com.whosinapp.whosinappclient.homepage.HomeActivity;

import android.content.Intent;
import android.text.Editable;
import android.widget.Toast;

public class MainActivityController {
	public static String GoodLoginToken = "";
	public MainActivityController(MainActivity mainActivity) {
		myActivity = mainActivity;
	}
	MainActivity myActivity;
	public void DoLogin(Editable text, Editable text2) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		String user = text.toString();
		String pass = text2.toString();
		LoginRequestDto myDto = new LoginRequestDto();
		myDto.setPassword(pass);
		myDto.setUserName(user);
		ServiceGateway theGate = new ServiceGateway();
		String myTokenOfAwesome ="";
		try {
			myTokenOfAwesome = theGate.Send(myDto);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (myTokenOfAwesome.length() > 0)
		{
			//Sweet Login
			Toast msg = new Toast(myActivity);
			
			msg.setText(myTokenOfAwesome);
			msg.show();
			GoodLoginToken = myTokenOfAwesome;
			Intent goToMainPage = new Intent(myActivity,HomeActivity.class);
			myActivity.startActivity(goToMainPage);
		
		}
		else
		{
			Toast fail = new Toast(myActivity);
			fail.setText("LoginFail");
			fail.show();
			//Fail Login
		}
		
	}

}
