package com.whosinapp.whosinappclient;

import java.io.IOException;
import java.util.*;
import org.json.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.whosinapp.whosinappclient.Login.LoginRequestDto;
import com.whosinapp.whosinappclient.NewUser.NewUserRequestDto;

public class ServiceGateway {
	
	public void Send(LoginRequestDto dto) throws ClientProtocolException, IOException {
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("email", dto.getUserName());
		m.put("password", dto.getPassword());
		
		JSONObject j = new JSONObject(m);
		
		HttpPost httpPost = new HttpPost("http://192.168.0.9:3000/api/v1/tokens.json");

        httpPost.setEntity(new StringEntity(j.toString()));

        httpPost.setHeader("Accept", "application/json");

        httpPost.setHeader("Content-type", "application/json");
        
        HttpClient webClient = new DefaultHttpClient();
        webClient.execute(httpPost);
	}

	public void Send(NewUserRequestDto dto) throws ClientProtocolException, IOException {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("firstName", dto.getFirstName());
		map.put("lastName", dto.getLastName());
		map.put("password",dto.getPassword());
		map.put("passwordConfirmation", dto.getPasswordConfirmation());
		map.put("emailAddress",dto.getEmailAddress());
		
		JSONObject jsonBuilder = new JSONObject(map);
		HttpPost poster = new HttpPost("http://192.168.0.9:3000/Nick Sucks");
		poster.setEntity(new StringEntity(jsonBuilder.toString()));
		poster.setHeader("Accept","application/json");
		poster.setHeader("Content-type", "application/json");
		HttpClient webSender = new DefaultHttpClient();
		webSender.execute(poster);
	}
}
