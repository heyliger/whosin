package com.whosinapp.whosinappclient.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.whosinapp.whosinappclient.ServiceGateway;
import com.whosinapp.whosinappclient.Login.LoginActivityController;
import com.whosinapp.whosinappclient.Login.LoginRequestDto;
import com.whosinapp.whosinappclient.adduserstoevent.SearchForUserByEmailDto;
import com.whosinapp.whosinappclient.models.User;

import android.test.AndroidTestCase;

public class ServiceGatewayTest extends AndroidTestCase{
	
	ServiceGateway _serviceGateway;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		LoginRequestDto loginDto = new LoginRequestDto();
		
		loginDto.setPassword("please");
		loginDto.setUserName("user@example.com");
		
		_serviceGateway = new ServiceGateway();
		
		String myTokenOfAwesome = _serviceGateway.Send(loginDto);
		
		LoginActivityController.GoodLoginToken = myTokenOfAwesome;
	}
 
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	

	public void testSearchForUserByEmail() throws JSONException{
		
		SearchForUserByEmailDto dto = new SearchForUserByEmailDto(); 
		
		dto.setEmail("user@example.com");
		
		try {
			
			_serviceGateway.Send(dto);	
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//assertEquals(9,mClassToTest.add(mArg1,mArg2));
	}

	public void testFailToFindUserByEmail() throws JSONException{
		
		SearchForUserByEmailDto dto = new SearchForUserByEmailDto(); 
		
		dto.setEmail("user@notregistered.com");
		
		try {
			
			User user = _serviceGateway.Send(dto);	
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//assertEquals(9,mClassToTest.add(mArg1,mArg2));
	}
	
}
