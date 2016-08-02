package com.example.test.activity;

import com.example.androidtest.R;
import com.example.test.adapter.GroupListAdapter;
import com.example.test.data.GroupData;
import com.example.test.data.GroupDataItem;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class GroupListActivity extends Activity {

	ListView lvGroupList = null;
	
	private GroupListAdapter adapter = null;
	
	private GroupData groupData = new GroupData();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_list);
		
		lvGroupList = (ListView) this.findViewById(R.id.lvGroupList);
		
		this.setDemoData();
		
		adapter = new GroupListAdapter(this, groupData);
		lvGroupList.setAdapter(adapter);
	}
	
	private void setDemoData()
	{
		for(int i=0;i<3;i++) {
			groupData.AddItem("A", new GroupDataItem("aaaaa"+i));
		}

		for(int i=0;i<3;i++) {
			groupData.AddItem("B", new GroupDataItem("bbbbb"+i));
		}
		
		for(int i=0;i<10;i++) {
			groupData.AddItem("C", new GroupDataItem("ccccc"+(i+5)));
		}
		
		groupData.AddItem("C", new GroupDataItem("ccccc"+3));
		groupData.AddItem("C", new GroupDataItem("ccccc"+1));
	}
}
