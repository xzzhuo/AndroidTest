package com.example.androidtest;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SettingFragment extends Fragment {
	
	private TextView tv;
	private Button btnTest;
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
        
    	View settingLayout = inflater.inflate(R.layout.fragement_setting, container, false);
        
        tv = (TextView) settingLayout.findViewById(R.id.setting);
        tv.setText("这是设置界面");
        
        btnTest = (Button) settingLayout.findViewById(R.id.btnTest);
        
        btnTest.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClass(getActivity(), TestMenuActivity.class);
				
				getActivity().startActivity(intent);
			}
        	
        });
        
        return settingLayout;
     }
}
