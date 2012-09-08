package com.whosinapp.whosinappclient.NewUser;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.R.layout;
import com.whosinapp.whosinappclient.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewUserActivity extends Activity
implements OnClickListener
{
	NewUserActivityController controller = new NewUserActivityController(this);
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        Button submitButton = (Button)this.findViewById(R.id.button_Submit);
        submitButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_new_user, menu);
        return true;
    }

    private String getTextFromEditViewById(int id)
    {
    	EditText theEditView = (EditText)this.findViewById(id);
    	return theEditView.getText().toString();
    }
	public void onClick(View arg0) {
		String FirstName = getTextFromEditViewById(R.id.editText_firstName);
		
		String LastName= getTextFromEditViewById(R.id.editText_LastName);
		String EmailAddress= getTextFromEditViewById(R.id.editText_Email);
		String Password= getTextFromEditViewById(R.id.editText_password);
		String PasswordRepeat= getTextFromEditViewById(R.id.editText_passConfirm);
		
		
	}
}
