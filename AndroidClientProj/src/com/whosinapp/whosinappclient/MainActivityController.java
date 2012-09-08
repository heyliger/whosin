package com.whosinapp.whosinappclient;

import android.text.Editable;

public class MainActivityController {

	public MainActivityController(MainActivity mainActivity) {
		// TODO Auto-generated constructor stub
	}

	public void DoLogin(Editable text, Editable text2) {
		// TODO Auto-generated method stub
		String user = text.toString();
		String pass = text2.toString();
		LoginRequestDto myDto = new LoginRequestDto();
		myDto.setPassword(pass);
		myDto.setUserName(user);
		ServiceGateway theGate = new ServiceGateway();
		theGate.Send(myDto);
	}

}
