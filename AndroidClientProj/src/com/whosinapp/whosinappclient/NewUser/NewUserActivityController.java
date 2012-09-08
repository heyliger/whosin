package com.whosinapp.whosinappclient.NewUser;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.whosinapp.whosinappclient.ServiceGateway;

public class NewUserActivityController {

	public NewUserActivityController(NewUserActivity newUserActivity) {
		// TODO Auto-generated constructor stub
	}

	public void SubmitNewUser(String firstName, String lastName,
			String emailAddress, String password, String passwordRepeat) {
		NewUserRequestDto dto = new NewUserRequestDto();
		dto.setEmailAddress(emailAddress);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setPassword(password);
		dto.setPasswordConfirmation(passwordRepeat);
		
		ServiceGateway gate = new ServiceGateway();
		try {
			gate.Send(dto);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
