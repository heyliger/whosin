package com.whosinapp.whosinappclient.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.whosinapp.whosinappclient.R;
import com.whosinapp.whosinappclient.models.User;

public class UserAdapter extends ArrayAdapter<User> {

    private ArrayList<User> items;
    private Context _context;
    

    public UserAdapter(Context context, int textViewResourceId, ArrayList<User> items) {
            super(context, textViewResourceId, items);
            _context = context;
            this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.user_row, null);
            }
            User user = items.get(position);
            if (user != null) {
                    TextView tt = (TextView) v.findViewById(R.id.toptext);
                    TextView bt = (TextView) v.findViewById(R.id.bottomtext);
                    if (tt != null) {
                          tt.setText("Name: " + user.getFirstName() + " " + user.getLastName());                            }
                    if(bt != null){
                          bt.setText("Email: "+ user.getEmail());
                    }
            }
            return v;
    }
}