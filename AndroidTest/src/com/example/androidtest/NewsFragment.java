package com.example.androidtest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsFragment extends Fragment {
	private TextView tv;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
        View messageLayout = inflater.inflate(R.layout.fragement_news, container, false);
        tv=(TextView) messageLayout.findViewById(R.id.news);
        tv.setText("这里是动态消息");
        return messageLayout;
     }
}
