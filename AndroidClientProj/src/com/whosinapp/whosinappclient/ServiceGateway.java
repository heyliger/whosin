package com.whosinapp.whosinappclient;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import org.json.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class ServiceGateway {
	
	public void Send(LoginRequestDto dto) throws ClientProtocolException, IOException {
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("username", dto.getUserName());
		m.put("password", dto.getPassword());
		
		JSONObject j = new JSONObject(m);
		
		HttpPost httpPost = new HttpPost("http://192.168.0.9:3000/");

        httpPost.setEntity(new StringEntity(j.toString()));

        httpPost.setHeader("Accept", "application/json");

        httpPost.setHeader("Content-type", "application/json");
        
        HttpClient webClient = new DefaultHttpClient();
        webClient.execute(httpPost);
	}

}
