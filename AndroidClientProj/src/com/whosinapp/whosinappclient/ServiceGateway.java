package com.whosinapp.whosinappclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;
import org.json.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

import com.whosinapp.whosinappclient.Login.LoginActivityController;
import com.whosinapp.whosinappclient.Login.LoginRequestDto;
import com.whosinapp.whosinappclient.NewUser.NewUserRequestDto;
import com.whosinapp.whosinappclient.createevent.CreateEventDto;
import com.whosinapp.whosinappclient.logout.LogoutRequestDto;

public class ServiceGateway {
	
	private final static String TAG = ServiceGateway.class.getSimpleName();
	private static String serverURI = "http://192.168.0.9:3000";
	public void Send(LogoutRequestDto logoutReq) throws ClientProtocolException, IOException{
		HttpDelete theDelete = new HttpDelete(serverURI+"/api/v1/tokens/"+logoutReq.getToken()+".json");
		theDelete.setHeader("Content-Type", "application/x-www-form-urlencoded");
		HttpClient webClient = new DefaultHttpClient();
		webClient.execute(theDelete);
	}
	public String Send(LoginRequestDto loginReq) throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("email", loginReq.getUserName());
		m.put("password", loginReq.getPassword());
		
		JSONObject j = new JSONObject(m);
		
		HttpPost httpPost = new HttpPost(serverURI+"/api/v1/tokens.json");

        httpPost.setEntity(new StringEntity(j.toString()));

        //httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-type", "application/json");
		
        
        HttpClient webClient = new DefaultHttpClient();
        HttpResponse theResponse = webClient.execute(httpPost);
        BufferedReader reader = new BufferedReader(new InputStreamReader(theResponse.getEntity().getContent(), "UTF-8"));
		
		JSONObject replyReader = new JSONObject(reader.readLine());
        return replyReader.get("token").toString();
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
	public int Send(CreateEventDto dto) {
		// TODO Auto-generated method stub
		Map<String,String> theJsonMap = new HashMap<String,String>();
		theJsonMap.put("name",dto.getName());
		theJsonMap.put("date_and_time(1i)", Integer.toString(dto.getYear()));
		theJsonMap.put("date_and_time(2i)",Integer.toString(dto.getMonth()));
		theJsonMap.put("date_and_time(3i)",Integer.toString(dto.getDay()));
		theJsonMap.put("date_and_time(4i)",Integer.toString(dto.getHour()));
		theJsonMap.put("date_and_time(5i)",Integer.toString(dto.getMinute()));
		theJsonMap.put("auth_token", LoginActivityController.GoodLoginToken);
		JSONObject innerJsonObj = new JSONObject(theJsonMap);
		
		Map<String,JSONObject> theOuterJson = new HashMap<String,JSONObject>();
		theOuterJson.put("event", innerJsonObj);
		JSONObject eventObj = new JSONObject(theOuterJson);
		HttpPost eventPoster = new HttpPost(serverURI+"/events.json");
		try {
			eventPoster.setEntity(new StringEntity(eventObj.toString()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eventPoster.setHeader("Accept","application/json");
		eventPoster.setHeader("Content-type", "application/json");
		HttpClient webSender = new DefaultHttpClient();
		
		
		try {
			HttpResponse response = webSender.execute(eventPoster);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			JSONObject reply = new JSONObject(reader.readLine());
			return reply.getInt("id");
			
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
		return 0;
		
	}
}
