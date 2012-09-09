package com.whosinapp.whosinappclient.getalleventsforuser;

import java.util.ArrayList;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.R.layout;
import com.whosinapp.whosinappclient.R.menu;
import com.whosinapp.whosinappclient.models.EventInfoStub;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.ScrollView;

public class ShowAllEventsForUserActivity extends Activity
implements OnClickListener
{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_events_for_user);
        myController = new ShowAllEventsForUserActivityController(this);
        ArrayList<EventInfoStub> events = myController.RetrieveAllEventsForUser();
        ListViewEventDataAdapter adapt = new ListViewEventDataAdapter(this.getApplicationContext(),events);
        ListView view = (ListView)this.findViewById(R.id.listView_eventList);
        view.setAdapter(adapt);
        adapt.notifyDataSetChanged();
        
        }
    private ShowAllEventsForUserActivityController myController;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_show_all_events_for_user, menu);
        return true;
    }

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
