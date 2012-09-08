package com.whosinapp.whosinappclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import org.json.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

import com.whosinapp.whosinappclient.Login.LoginRequestDto;
import com.whosinapp.whosinappclient.NewUser.NewUserRequestDto;

public class ServiceGateway {
	
	private final static String TAG = ServiceGateway.class.getSimpleName();
	private static String serverURI = "http://192.168.0.9:3000";
	public void Send(LoginRequestDto dto) throws ClientProtocolException, IOException {
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("email", dto.getUserName());
		m.put("password", dto.getPassword());
		
		JSONObject j = new JSONObject(m);
		
		HttpPost httpPost = new HttpPost(serverURI+"/api/v1/tokens.json");

        httpPost.setEntity(new StringEntity(j.toString()));

        //httpPost.setHeader("Accept", "application/json");

        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        
        HttpClient webClient = new DefaultHttpClient();
        webClient.execute(httpPost);
	}

	public void Send(NewUserRequestDto dto) throws ClientProtocolException, IOException {
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("first_name", dto.getFirstName());
		map.put("last_name", dto.getLastName());
		map.put("password",dto.getPassword());
		map.put("password_confirmation", dto.getPasswordConfirmation());
		map.put("email",dto.getEmailAddress());
		
		JSONObject jsonBuilder = new JSONObject(map);						
		Map<String,JSONObject> tmp = new HashMap<String,JSONObject>();
		
		tmp.put("user", jsonBuilder);
		
		JSONObject jsonBuilder2 = new JSONObject(tmp);
		
		HttpPost poster = new HttpPost(serverURI+"/users.json");
		poster.setEntity(new StringEntity(jsonBuilder2.toString()));
		poster.setHeader("Accept","application/json");
		poster.setHeader("Content-type", "application/json");
		HttpClient webSender = new DefaultHttpClient();
		
		
		HttpResponse response = webSender.execute(poster);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
		StringBuilder builder = new StringBuilder();
		for (String line = null; (line = reader.readLine()) != null;) {
		    builder.append(line).append("\n");
		}
		JSONTokener tokener = new JSONTokener(builder.toString());
		JSONArray finalResult;
		try {
			finalResult = new JSONArray(tokener);
			Log.d(TAG, "HttpResponse: " + finalResult.toString());
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage());
			e.printStackTrace();
		}

		
		
		
		

		
		
	}
}
