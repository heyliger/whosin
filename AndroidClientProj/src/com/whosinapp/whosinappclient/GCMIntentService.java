package com.whosinapp.whosinappclient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gcm.GCMBaseIntentService;
import com.whosinapp.whosinappclient.registerdevice.RegisterDeviceDto;

public class GCMIntentService extends GCMBaseIntentService {

	public GCMIntentService() {
		super("1068757721296");
	}
	
	@Override
	protected void onError(Context arg0, String error) {
		/*
		 * Called when the device tries to register or unregister, 
		 * but GCM returned an error. Typically, there is nothing to 
		 * be done other than evaluating the error (returned by errorId) 
		 * and trying to fix the problem.
		 */
		Context context = getApplicationContext();
		CharSequence text = error;
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	@Override
	protected void onMessage(Context c, Intent intent) {
		/*
		 * Called when your server sends a message to GCM, and GCM delivers 
		 * it to the device. If the message has a payload, its contents are 
		 * available as extras in the intent.
		 */
		Context context = getApplicationContext();
		CharSequence text = "test";//intent.getStringExtra(name);
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	@Override
	protected void onRegistered(Context context, String registrationId) {
		// TODO Auto-generated method stub
		/*
		 * Called after a registration intent is received, passes the registration ID 
		 * assigned by GCM to that device/application pair as parameter. Typically, 
		 * you should send the regid to your server so it can use it to send messages 
		 * to this device.
		 */
		ServiceGateway theGateway = new ServiceGateway();
		RegisterDeviceDto dto = new	RegisterDeviceDto();
		// TODO Get Device identifier
		dto.setDescription("test_description");
		dto.setRegistrationId(registrationId);
		try {
			theGateway.Send(dto);
		} catch (ClientProtocolException e) {
			Log.e(TAG, e.getMessage());
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());

		}
	}

	@Override
	protected void onUnregistered(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		/*
		 * Called after the device has been unregistered from GCM. 
		 * Typically, you should send the regid to the server so it 
		 * unregisters the device.
		 */
	}
	
	/*protected boolean onRecoverableError(Context context, String errorId) {
		*
		 * Called when the device tries to register or unregister, 
		 * but the GCM servers are unavailable. The GCM library will 
		 * retry the operation using exponential backup, unless this 
		 * method is overridden and returns false. This method is 
		 * optional and should be overridden only if you want to 
		 * display the message to the user or cancel the retry attempts. 
		 *
	}*/

}
