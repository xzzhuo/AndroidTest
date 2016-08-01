package com.example.androidtest;

import com.example.test.activity.GroupListActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestMenuActivity extends Activity implements OnClickListener {

	Button btnGroupListView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_menu);
		
		btnGroupListView = (Button) this.findViewById(R.id.btnGroupListView);
		btnGroupListView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btnGroupListView)
		{
			Intent intent = new Intent();
			intent.setClass(this, GroupListActivity.class);
			this.startActivity(intent);
		}
	}
}
