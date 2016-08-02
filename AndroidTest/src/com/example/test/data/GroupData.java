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
		for (Entry<String, List<GroupDataItem>> entry : mGroupDataList.entrySet())
		{
			Collections.sort(entry.getValue(), new Comparator<GroupDataItem>() {

				@Override
				public int compare(GroupDataItem lhs, GroupDataItem rhs) {
					return lhs.itemTest.compareTo(rhs.itemTest);
				}

			});
		}
		
		List<GroupPointerItem> listItem = new ArrayList<GroupPointerItem>();
		
		List<String> keyList = new ArrayList<String>(mGroupDataList.keySet());
		Collections.sort(keyList);
		
		for (String key : keyList) {
			List<GroupDataItem> groupItems = mGroupDataList.get(key);
			
			listItem.add(new GroupPointerItem(key, null));
			
			for (GroupDataItem item : groupItems)
			{
				listItem.add(new GroupPointerItem(key, item));
			}
		}
		
		return listItem;
	}
}
