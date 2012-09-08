package com.whosinapp.whosinappclient.Login;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.whosinapp.whosinappclient.*;
import com.whosinapp.whosinappclient.homepage.HomeActivity;

import android.content.Intent;
import android.text.Editable;
import android.widget.Toast;

public class LoginActivityController {
	public static String GoodLoginToken = "";
	public LoginActivityController(LoginActivity mainActivity) {
		myActivity = mainActivity;
	}
	LoginActivity myActivity;
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
			GoodLoginToken = myTokenOfAwesome;
			Intent goToMainPage = new Intent(myActivity,HomeActivity.class);
			myActivity.startActivity(goToMainPage);
		
		}
		else
		{
			//Fail Login
		}
		
	}

}
