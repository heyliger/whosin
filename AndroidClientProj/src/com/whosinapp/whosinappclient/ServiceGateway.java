package com.whosinapp.whosinappclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import org.json.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

import com.whosinapp.whosinappclient.Login.LoginActivity;
import com.whosinapp.whosinappclient.Login.LoginActivityController;
import com.whosinapp.whosinappclient.Login.LoginRequestDto;
import com.whosinapp.whosinappclient.NewUser.NewUserRequestDto;
import com.whosinapp.whosinappclient.adduserstoevent.AddUsersToEventDto;
import com.whosinapp.whosinappclient.adduserstoevent.SearchForUserByEmailDto;
import com.whosinapp.whosinappclient.createevent.CreateEventDto;
import com.whosinapp.whosinappclient.creategroup.CreateGroupDto;
import com.whosinapp.whosinappclient.getalleventsforuser.GetAllEventsForUserDto;
import com.whosinapp.whosinappclient.getgroupsforuser.GetGroupsForUserDto;
import com.whosinapp.whosinappclient.getusersforgroup.GetUsersForGroupDto;
import com.whosinapp.whosinappclient.logout.LogoutRequestDto;
import com.whosinapp.whosinappclient.models.EventInfoStub;
import com.whosinapp.whosinappclient.models.User;
import com.whosinapp.whosinappclient.registerdevice.RegisterDeviceDto;
import com.whosinapp.whosinappclient.utils.StringUtils;

public class ServiceGateway {

	private final static String TAG = ServiceGateway.class.getSimpleName();
	private static String serverURI = "http://192.168.1.79:3000";

	public ArrayList<String> Retrieve(GetUsersForGroupDto groupReq) {
		ArrayList<String> results = new ArrayList<String>();
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setHeader("Content-type", "application/json");
			request.setHeader("Accept", "application/json");
			request.setHeader("X-API-KEY",
					LoginActivityController.GoodLoginToken);
			request.setURI(new URI(serverURI + "/groups.json/?name="
					+ groupReq.getGroup()));
			HttpResponse response = client.execute(request);

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent(), "UTF-8"));

			JSONArray replyReader = new JSONArray(reader.readLine());
			for (int i = 0; i < replyReader.length(); i++) {
				results.add(((JSONObject) replyReader.get(i)).get("name")
						.toString());
			}
		} catch (Exception err) {
			Log.e("Retrieve(GetUsersForGroupDto groupReq)", err.getMessage());
		}
		return results;
	}

	public ArrayList<String> Retrieve(GetGroupsForUserDto userReq)
	{
		ArrayList<String> results = new ArrayList<String>();
	        try {
	            HttpClient client = new DefaultHttpClient();
	            HttpGet request = new HttpGet();
	            request.setHeader("Content-type", "application/json");
	            request.setHeader("Accept","application/json");
	            request.setHeader("X-API-KEY",LoginActivityController.GoodLoginToken);
	            request.setURI(new URI(serverURI+"/groups.json/?id="+ LoginActivityController.GoodLoginToken));
	            HttpResponse response = client.execute(request);
	            
	            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
	    		
	    		JSONArray replyReader = new JSONArray(reader.readLine());
	    		for(int i = 0; i < replyReader.length(); i++)
	    		{
	    			results.add(((JSONObject)replyReader.get(i)).get("name").toString());
	    		}
	        }
	        catch(Exception err)
	        {
	        	Log.e("Retrieve(GetUsersForGroupDto groupReq)", err.getMessage());
	        }
	            return results;
	}

	public void Send(LogoutRequestDto logoutReq)
			throws ClientProtocolException, IOException, JSONException {
		HttpDelete theDelete = new HttpDelete(serverURI + "/api/v1/tokens/"
				+ logoutReq.getToken() + ".json");
		theDelete.setHeader("X-API-KEY", logoutReq.getToken());
		theDelete
				.setHeader("Content-Type", "application/x-www-form-urlencoded");

		HttpClient webClient = new DefaultHttpClient();
		HttpResponse webResponse = webClient.execute(theDelete);
	}
	
	public void Send(RegisterDeviceDto dto) 
			throws ClientProtocolException, IOException {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("description", dto.getDescription());
		map.put("registration_id", dto.getRegistrationId());

		JSONObject jsonBuilder = new JSONObject(map);
		Map<String, JSONObject> tmp = new HashMap<String, JSONObject>();

		tmp.put("device", jsonBuilder);

		JSONObject jsonBuilder2 = new JSONObject(tmp);

		HttpPost poster = new HttpPost(serverURI + "/devices.json");
		poster.setEntity(new StringEntity(jsonBuilder2.toString()));
		poster.setHeader("Accept", "application/json");
		poster.setHeader("Content-type", "application/json");
		poster.setHeader("X-API-KEY", LoginActivityController.GoodLoginToken);
		HttpClient webSender = new DefaultHttpClient();

		HttpResponse response = webSender.execute(poster);

		/*BufferedReader reader = new BufferedReader(new InputStreamReader(
				response.getEntity().getContent(), "UTF-8"));
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
		}*/
	}
	
	public ArrayList<EventInfoStub> Send(GetAllEventsForUserDto dto)
	{
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet();
        request.setHeader("Content-type", "application/json");
        request.setHeader("Accept","application/json");
        request.setHeader("X-API-KEY",LoginActivityController.GoodLoginToken);
        try {
			request.setURI(new URI(serverURI+"/events.json"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        HttpResponse webResponse = null;
		try {
			webResponse = client.execute(request);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					webResponse.getEntity().getContent(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder();
		try {
			for (String line = null; (line = reader.readLine()) != null;) {
				builder.append(line).append("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			JSONArray theArr = null;
			try {
				theArr = new JSONArray(builder.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<EventInfoStub> retValues = new ArrayList<EventInfoStub>();
			for(int i=0;i<theArr.length();i++)
			{
				JSONObject currentEvent = null;
				try {
					currentEvent = (JSONObject) theArr.get(i);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				EventInfoStub stub = new EventInfoStub();
				try {
					stub.setName(currentEvent.getString("name"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				retValues.add(stub);
			}
			return retValues;
	
		
	}

	public String Send(LoginRequestDto loginReq)
			throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("email", loginReq.getUserName());
		m.put("password", loginReq.getPassword());

		JSONObject j = new JSONObject(m);

		HttpPost httpPost = new HttpPost(serverURI + "/api/v1/tokens.json");

		httpPost.setEntity(new StringEntity(j.toString()));

		// httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setHeader("X-API-KEY", LoginActivityController.GoodLoginToken);

		HttpClient webClient = new DefaultHttpClient();
		HttpResponse theResponse = webClient.execute(httpPost);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				theResponse.getEntity().getContent(), "UTF-8"));

		JSONObject replyReader = new JSONObject(reader.readLine());
		return replyReader.get("token").toString();
	}

	public void Send(NewUserRequestDto dto) throws ClientProtocolException,
			IOException {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("first_name", dto.getFirstName());
		map.put("last_name", dto.getLastName());
		map.put("password", dto.getPassword());
		map.put("password_confirmation", dto.getPasswordConfirmation());
		map.put("email", dto.getEmailAddress());

		JSONObject jsonBuilder = new JSONObject(map);
		Map<String, JSONObject> tmp = new HashMap<String, JSONObject>();

		tmp.put("user", jsonBuilder);

		JSONObject jsonBuilder2 = new JSONObject(tmp);

		HttpPost poster = new HttpPost(serverURI + "/users.json");
		poster.setEntity(new StringEntity(jsonBuilder2.toString()));
		poster.setHeader("Accept", "application/json");
		poster.setHeader("Content-type", "application/json");
		poster.setHeader("X-API-KEY", LoginActivityController.GoodLoginToken);
		HttpClient webSender = new DefaultHttpClient();

		HttpResponse response = webSender.execute(poster);

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				response.getEntity().getContent(), "UTF-8"));
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
	
	public void Send(AddUsersToEventDto dto) throws ClientProtocolException, IOException{
		
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("invitees", StringUtils.join(dto.getUserIds(), ","));

		JSONObject jsonBuilder = new JSONObject(map);

		HttpPut putter = new HttpPut(serverURI + "/events/" + dto.getEventId() + "/invite.json");
		putter.setEntity(new StringEntity(jsonBuilder.toString()));

		putter.setHeader("Accept", "application/json");
		putter.setHeader("Content-type", "application/json");
		putter.setHeader("X-API-KEY", LoginActivityController.GoodLoginToken);
		HttpClient webSender = new DefaultHttpClient();
		
		HttpResponse response;
		response = webSender.execute(putter);
		
	}

	/**
	 * 
	 * @param dto
	 * @return The ID of the user if we found their email address
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws JSONException
	 */
	public User Send(SearchForUserByEmailDto dto)
			throws ClientProtocolException, IOException, JSONException {

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("email", dto.getEmail());

		JSONObject jsonBuilder = new JSONObject(map);

		HttpPost poster = new HttpPost(serverURI + "/users/by_email.json");
		poster.setEntity(new StringEntity(jsonBuilder.toString()));

		poster.setHeader("Accept", "application/json");
		poster.setHeader("Content-type", "application/json");
		poster.setHeader("X-API-KEY", LoginActivityController.GoodLoginToken);
		HttpClient webSender = new DefaultHttpClient();

		HttpResponse response;
		response = webSender.execute(poster);

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				response.getEntity().getContent(), "UTF-8"));

		StringBuilder builder = new StringBuilder();
		for (String line = null; (line = reader.readLine()) != null;) {
			builder.append(line).append("\n");
		}
		JSONTokener tokener = new JSONTokener(builder.toString());

		User user = null;

		try {
			JSONObject object = (JSONObject) tokener.nextValue();

			user = new User();

			user.setFirstName(object.get("first_name").toString());
			user.setLastName(object.get("last_name").toString());
			user.setEmail(object.get("email").toString());
			user.setId(Long.parseLong(object.get("id").toString()));

		} catch (Exception ex) {
			Log.d("TAG", "couldn't parse shit");
		}

		return user;

		// JSONArray finalResult;
		// try {
		// finalResult = new JSONArray(tokener);
		// Log.d(TAG, "HttpResponse: " + finalResult.toString());
		// // if we found the user, return their id
		// if (finalResult.toString().equals("yay")){
		// return 1;
		// }
		//
		// } catch (JSONException e) {
		// Log.e(TAG, e.getMessage());
		// e.printStackTrace();
		// }
		//
		// return -1;

	}

	public int Send(CreateEventDto dto) {

		// TODO Auto-generated method stub
		Map<String, String> theJsonMap = new HashMap<String, String>();
		theJsonMap.put("name", dto.getName());
		theJsonMap.put("date_and_time", dto.getDateAndTime());


		JSONObject eventObj = new JSONObject(theJsonMap);
		HttpPost eventPoster = new HttpPost(serverURI + "/events.json");
		try {
			eventPoster.setEntity(new StringEntity(eventObj.toString()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eventPoster.setHeader("Accept", "application/json");
		eventPoster.setHeader("X-API-KEY",
				LoginActivityController.GoodLoginToken);
		eventPoster.setHeader("Content-type", "application/json");
		HttpClient webSender = new DefaultHttpClient();

		try {
			HttpResponse response = webSender.execute(eventPoster);

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent(), "UTF-8"));
			JSONObject reply = new JSONObject(reader.readLine());
			
			int groupId = reply.getInt("id");
			
			return groupId;

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return 0;

	}

	public void Send(CreateGroupDto dto) {
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("name", dto.getGroupName());
		JSONObject request = new JSONObject(jsonMap);
		HttpPost eventPoster = new HttpPost(serverURI + "/groups.json");
		try {
			eventPoster.setEntity(new StringEntity(request.toString()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eventPoster.setHeader("Accept", "application/json");
		eventPoster.setHeader("X-API-KEY",
				LoginActivityController.GoodLoginToken);
		eventPoster.setHeader("Content-type", "application/json");
		HttpClient webSender = new DefaultHttpClient();

		try {
			HttpResponse response = webSender.execute(eventPoster);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
