package com.whosinapp.whosinappclient.getalleventsforuser;

import java.util.ArrayList;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.models.EventInfoStub;
import com.whosinapp.whosinappclient.models.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewEventDataAdapter extends ArrayAdapter<EventInfoStub>{

	public ListViewEventDataAdapter(Context mContext, ArrayList<EventInfoStub> datas)
	{
		super(mContext, R.layout.eventlistview, datas);
		myEvents = new ArrayList<EventInfoStub>();
		for (EventInfoStub item : datas) {
		    myEvents.add(item);
		}
		theContext = mContext;
	}
	Context theContext;
	ArrayList<EventInfoStub> myEvents;

	public View getView(int arg0, View arg1, ViewGroup arg2) {
	
		View theView = LayoutInflater.from(theContext).inflate(R.layout.eventlistview,null);
		EventInfoStub theEvent = myEvents.get(arg0);
		TextView item = (TextView)theView.findViewById(R.id.textView_EventList_Name);
		item.setText(theEvent.getName());
		return theView;
	}
	
	

}
