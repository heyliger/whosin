package com.whosinapp.whoisinappclient.getallgroupsforuser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class GetUsersForGroupController {
	
	public ArrayList<String> ReturnUsersForGroup(String group) {
		//need to add group to search param and set message protocol
		
		ArrayList<String> results = new ArrayList<String>();
		 BufferedReader in = null;
	        try {
	            HttpClient client = new DefaultHttpClient();
	            HttpGet request = new HttpGet();
	            request.setURI(new URI("http://suckit.com/"));
	            HttpResponse response = client.execute(request);
	            in = new BufferedReader
	            (new InputStreamReader(response.getEntity().getContent()));
	            String line = "";
	            while ((line = in.readLine()) != null) {
	                results.add(line);
	            }
	            in.close();
	            } catch (Exception e) {
					// TODO Auto-generated catch block
					Log.e("ReturnUsersForGroup",e.toString());
				}
	        	finally {
	            if (in != null) {
	                try {
	                    in.close();
	                    } catch (IOException e) {
	                    	Log.e("ReturnUsersForGroup", e.toString());
	                } 
	            }
	        }
			return results;
	}
}
