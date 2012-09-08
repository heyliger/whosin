package com.whosinapp.whosinappclient;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LogoutActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_logout, menu);
        return true;
    }
}
