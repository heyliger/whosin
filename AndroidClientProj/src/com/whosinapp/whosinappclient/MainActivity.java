package com.whosinapp.whosinappclient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
implements OnClickListener
{
	MainActivityController myController = new MainActivityController(this);
	Button doLogin ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doLogin = (Button) this.findViewById( R.id.button1);
        doLogin.setClickable(true);
        doLogin.setOnClickListener((android.view.View.OnClickListener) this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		EditText userName = (EditText) this.findViewById(R.id.editText1);
		EditText passWord = (EditText) this.findViewById(R.id.editText2);
		
		try {
			myController.DoLogin(userName.getText(),passWord.getText());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
