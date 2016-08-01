package com.example.test.adapter;

import com.example.androidtest.R;
import com.example.test.data.GroupData;
import com.example.test.data.GroupPointerItem;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class GroupListAdapter extends ArrayAdapter<GroupPointerItem> {

	public GroupListAdapter(Context context, GroupData data) {
		super(context, 0, data.getDataList());
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View view = convertView;
		
		if (getItem(position).item == null) {
			view = LayoutInflater.from(getContext()).inflate(R.layout.adapter_group_list_item_tag, null);
		}
		else
		{
			view = LayoutInflater.from(getContext()).inflate(R.layout.adapter_group_list_item, null);
		}
		
		TextView textView = (TextView) view.findViewById(R.id.tvGroupListItemText);
		
		if (getItem(position).item == null) {
			textView.setText(getItem(position).groupName);
		}
		else
		{
			textView.setText(getItem(position).item.itemTest);
		}
		
		return view;
	}
	
	@Override
	public boolean isEnabled(int position) {
		if(getItem(position).item == null) {
			return false;
		}
		
		return super.isEnabled(position);
	}
}
