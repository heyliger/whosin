package com.whosinapp.whosinappclient.getalleventsforuser;

import java.util.ArrayList;

import com.whosinapp.whosinappclient.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListViewEventDataAdapter extends BaseAdapter{

	public ListViewEventDataAdapter(Context mContext, Iterable<EventInfoStub> datas)
	{
		myEvents = new ArrayList<EventInfoStub>();
		for (EventInfoStub item : datas) {
		    myEvents.add(item);
		}
		theContext = mContext;
	}
	Context theContext;
	ArrayList<EventInfoStub> myEvents;
	public int getCount() {
		// TODO Auto-generated method stub
		return myEvents.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return myEvents.get(arg0);
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return myEvents.get(arg0).getId();
	}

	public View getView(int arg0, View arg1, ViewGroup arg2) {
		View theView = LayoutInflater.from(theContext).inflate(R.layout.eventlistview,arg2,false);
		EventInfoStub theEvent = myEvents.get(arg0);
		
		return theView;
	}
	
	

}
