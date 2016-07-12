package com.example.androidtest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SettingFragment extends Fragment {
	private TextView tv;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
        View messageLayout = inflater.inflate(R.layout.fragement_setting, container, false);
        tv=(TextView) messageLayout.findViewById(R.id.setting);
        tv.setText("这是设置界面");
        return messageLayout;
     }
}
