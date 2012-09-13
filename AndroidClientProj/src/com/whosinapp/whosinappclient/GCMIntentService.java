package com.whosinapp.whosinappclient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gcm.GCMBaseIntentService;
import com.whosinapp.whosinappclient.registerdevice.RegisterDeviceDto;

public class GCMIntentService extends GCMBaseIntentService {

	// events come back on their own thread,
	// so we use this handler to invoke them back to the main thread
	Handler _mainThreadHandler = null;
	
	public GCMIntentService() {
		super("1068757721296");
		_mainThreadHandler = new Handler();
	}
	
	@Override
	protected void onError(Context arg0, String error) {
		/*
		 * Called when the device tries to register or unregister, 
		 * but GCM returned an error. Typically, there is nothing to 
		 * be done other than evaluating the error (returned by errorId) 
		 * and trying to fix the problem.
		 */
		
	}

	@Override
	protected void onMessage(Context c, Intent intent) {
		/*
		 * Called when your server sends a message to GCM, and GCM delivers 
		 * it to the device. If the message has a payload, its contents are 
		 * available as extras in the intent.
		 */
		
		// This is like a dispatcher.invoke call in .NET
		final String messageText = intent.getStringExtra("message_text");
		
		_mainThreadHandler.post(new Runnable() {
			String message = messageText;
			@Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
		
		
				
		Log.v(TAG, "GCM Message Arrived: " + messageText);
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
		sendRegistrationToServer(registrationId);
	}

	public static void sendRegistrationToServer(String registrationId) {
		ServiceGateway theGateway = new ServiceGateway();
		RegisterDeviceDto dto = new	RegisterDeviceDto();
		
		String device = android.os.Build.DEVICE;
		String brand = android.os.Build.BRAND;
		String man = android.os.Build.MANUFACTURER;
		String model = android.os.Build.MODEL;
		
		dto.setDescription(
				device + "-" + 
				brand + "-" +
				man + "-" + 
				model);
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
		// TODO When the app is uninstalled, the registration should
		// be revoked.
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
