package com.whosinapp.whoisinappclient.getusersforgroup;

import java.util.ArrayList;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.R.layout;
import com.whosinapp.whosinappclient.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ConsoleMessage;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class GetUsersForGroupActivity extends Activity implements OnClickListener {

	private GetUsersForGroupController controller = new GetUsersForGroupController();
	private ArrayList<String> values;
    private ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, R.id.listView_Get_Users_For_Group_Users_List, values);
    private ListView listView;
    private EditText editText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_users_for_group);
        listView = (ListView)this.findViewById(R.id.listView_Get_Users_For_Group_Users_List);
        listView.setAdapter(adapter);
        editText = (EditText)this.findViewById(R.id.editText_Get_Users_For_Group_Group);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_get_all_users_for_group, menu);
        return true;
    }
    
    public void ReturnUsersForGroup(View view) {
    		values = controller.ReturnUsersForGroup(editText.getText().toString());
    }

	public void onClick(View view) {
		// TODO Auto-generated method stub
		
	}
}
