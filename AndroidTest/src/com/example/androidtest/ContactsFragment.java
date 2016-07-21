package com.example.androidtest;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ContactsFragment extends BaseFragment {

	private TextView tv;
	private ListView lvContact;
	
	ContactsFragment(Context context, OnCreateListener listener)
	{
		super(context, listener);
	}
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
        View messageLayout = inflater.inflate(R.layout.fragement_contacts, container, false);
        tv=(TextView) messageLayout.findViewById(R.id.contact);
        tv.setText("这是联系人列表");
        
        lvContact = (ListView) messageLayout.findViewById(R.id.lvContact);
        
        if (this.mListener != null)
        {
        	this.mListener.onCreate();
        }
        
        return messageLayout;
     }
    
    public void updateContact(List<Map<String, Object>> list)
    {
    	if (lvContact == null)
    	{
    		return;
    	}
    	
    	lvContact.setAdapter(new SimpleAdapter(mContext,
    			list,
    			R.layout.adapter_contact, new String[] {"img", "account", "name"},
    			new int[] {R.id.img, R.id.account, R.id.name} ));
    }
}
