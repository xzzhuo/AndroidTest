package com.example.test.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupData {

	private Map<String, List<GroupDataItem>> mGroupDataList = null;
	
	public GroupData()
	{
		mGroupDataList = new HashMap<String, List<GroupDataItem>>();
	}
	
	public void AddItem(String groupName, GroupDataItem item)
	{
		if (mGroupDataList.containsKey(groupName))
		{
			List<GroupDataItem> items = mGroupDataList.get(groupName);
			items.add(item);
		}
		else
		{
			List<GroupDataItem> items = new ArrayList<GroupDataItem>();
			items.add(item);
			mGroupDataList.put(groupName, items);
		}
	}
	
	public List<GroupPointerItem> getDataList()
	{
		Collections.sort(mGroupDataList, new Comparator<Entry<String, List<GroupDataItem>>>() {

			@Override
			public int compare(Entry<String, List<GroupDataItem>> lhs,
					Entry<String, List<GroupDataItem>> rhs) {
				return (lhs.getKey()).compareTo(rhs.getKey());
			}
		});
		
		List<GroupPointerItem> listItem = new ArrayList<GroupPointerItem>();
		
		for (Entry<String, List<GroupDataItem>> attr : mGroupDataList.entrySet()) {
			String groupName = attr.getKey();
			List<GroupDataItem> groupItems = attr.getValue();
			
			listItem.add(new GroupPointerItem(groupName, null));
			
			for (GroupDataItem item : groupItems)
			{
				listItem.add(new GroupPointerItem(groupName, item));
			}
		}
		
		return listItem;
	}
}
