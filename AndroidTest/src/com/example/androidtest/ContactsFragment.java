package com.example.androidtest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactsFragment extends Fragment {
	private TextView tv;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
        View messageLayout = inflater.inflate(R.layout.fragement_contacts, container, false);
        tv=(TextView) messageLayout.findViewById(R.id.contact);
        tv.setText("这是联系人列表");
        return messageLayout;
     }
}
