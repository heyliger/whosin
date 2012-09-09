package com.whosinapp.whosinappclient.getgroupsforuser;

import java.util.ArrayList;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.R.layout;
import com.whosinapp.whosinappclient.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class GetGroupsForUserActivity extends Activity {
	private GetGroupsForUserController controller = new GetGroupsForUserController();
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> grouplist = new ArrayList<String>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_groups_for_user);
        listView = (ListView)findViewById(R.id.listView_Get_Groups_For_User_Group_List);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, R.id.listView_Get_Groups_For_User_Group_List, grouplist);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_get_groups_for_user, menu);
        return true;
    }
    
    public void ReturnGroupsForUser()
    {
    	grouplist = controller.ReturnGroupsForUser();
    }
}
