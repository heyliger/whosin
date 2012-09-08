package com.whosinapp.whosinappclient.Login;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import com.whosinapp.whosinappclient.*;
import android.text.Editable;

public class MainActivityController {

	public MainActivityController(MainActivity mainActivity) {
		// TODO Auto-generated constructor stub
	}

	public void DoLogin(Editable text, Editable text2) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		String user = text.toString();
		String pass = text2.toString();
		LoginRequestDto myDto = new LoginRequestDto();
		myDto.setPassword(pass);
		myDto.setUserName(user);
		ServiceGateway theGate = new ServiceGateway();
		theGate.Send(myDto);
		Boolean successfulLogin = true; // This should parse a response  I suppose
		if (successfulLogin)
		{
			//Intent goToMainPage = new Intent
		
		}
	}

}
