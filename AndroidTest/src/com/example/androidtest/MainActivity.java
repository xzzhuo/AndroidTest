package com.example.androidtest;

import com.example.websocket.MyWebSocket;
import com.example.websocket.WebSocketListener;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener, WebSocketListener  {

	private FragmentManager fragmentManager;
	
	private MessageFragment messageFragment;
	private ContactsFragment contactsFragment;
	private NewsFragment newsFragment;
	private SettingFragment settingFragment;
	
	private View messageLayout;
	private View contactsLayout;
	private View newsLayout;
	private View settingLayout;
	
	private MyWebSocket mWebSocket = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		fragmentManager = getFragmentManager();
		// 第一次启动时选中第0个tab
		setTabSelection(0);

		mWebSocket = new MyWebSocket();
		
		mWebSocket.connect("ws://10.100.13.75:8081/websocket", this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void initViews() {
	      messageLayout = findViewById(R.id.message_layout);
	      contactsLayout = findViewById(R.id.contacts_layout);
	      newsLayout = findViewById(R.id.news_layout);
	      settingLayout = findViewById(R.id.setting_layout);
	      messageLayout.setOnClickListener(this);
	      contactsLayout.setOnClickListener(this);
	      newsLayout.setOnClickListener(this);
	      settingLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
	     case R.id.message_layout:
	         // 当点击了消息tab时，选中第1个tab
	         setTabSelection(0);
	         break;
	      case R.id.contacts_layout:
	          // 当点击了联系人tab时，选中第2个tab
	          setTabSelection(1);
	          break;
	      case R.id.news_layout:
	            // 当点击了动态tab时，选中第3个tab
	            setTabSelection(2);
	            break;
	      case R.id.setting_layout:
	             // 当点击了设置tab时，选中第4个tab
	            setTabSelection(3);
	             break;
	      default:
	        break;
		}
	}

	private void setTabSelection(int index) {
		// 每次选中之前先清楚掉上次的选中状态
		clearSelection();
		// 开启一个Fragment事务
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		hideFragments(transaction);
		switch (index) {
		case 0:
			messageLayout.setBackgroundColor(0xff0000ff);
	 
			if (messageFragment == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				messageFragment = new MessageFragment();
				transaction.add(R.id.content, messageFragment);
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来
				transaction.show(messageFragment);
			}
			break;
		case 1:
			// 当点击了联系人tab时，改变控件的图片和文字颜色
			contactsLayout.setBackgroundColor(0xff0000ff);
			if (contactsFragment == null) {
				// 如果ContactsFragment为空，则创建一个并添加到界面上
				contactsFragment = new ContactsFragment();
				transaction.add(R.id.content, contactsFragment);
			} else {
				// 如果ContactsFragment不为空，则直接将它显示出来
				transaction.show(contactsFragment);
			}
			break;
		case 2:
			// 当点击了动态tab时，改变控件的图片和文字颜色
			newsLayout.setBackgroundColor(0xff0000ff);
			if (newsFragment == null) {
				// 如果NewsFragment为空，则创建一个并添加到界面上
				newsFragment = new NewsFragment();
				transaction.add(R.id.content, newsFragment);
			} else {
				// 如果NewsFragment不为空，则直接将它显示出来
				transaction.show(newsFragment);
			}
			break;
		case 3:
		default:
			// 当点击了设置tab时，改变控件的图片和文字颜色
			settingLayout.setBackgroundColor(0xff0000ff);
			if (settingFragment == null) {
				// 如果SettingFragment为空，则创建一个并添加到界面上
				settingFragment = new SettingFragment();
				transaction.add(R.id.content, settingFragment);
			} else {
				// 如果SettingFragment不为空，则直接将它显示出来
				transaction.show(settingFragment);
			}
			break;
		}
		transaction.commit();
	}
	
	private void hideFragments(FragmentTransaction transaction) {
		if (messageFragment != null) {
			transaction.hide(messageFragment);
		}
		if (contactsFragment != null) {
			transaction.hide(contactsFragment);
		}
		if (newsFragment != null) {
			transaction.hide(newsFragment);
		}
		if (settingFragment != null) {
			transaction.hide(settingFragment);
		}
	}
	
	private void clearSelection() {
		messageLayout.setBackgroundColor(0xffffffff);
		contactsLayout.setBackgroundColor(0xffffffff);
		newsLayout.setBackgroundColor(0xffffffff);
		settingLayout.setBackgroundColor(0xffffffff);
	}

	@Override
	public void onConnect(MyWebSocket client) {
		Log.d("WebSocket", "onConnect");

		String message = String.format("{\"command\":{\"name\":\"GET_FRIND_LIST\",\"account\":\" %s \"}}", "admin"); 
		mWebSocket.sendTextMessage(message);
	}

	@Override
	public void onTextMessage(MyWebSocket client, String message) {
		Log.d("WebSocket", "onTextMessage");
		
	}

	@Override
	public void onDisconnect(MyWebSocket client) {
		Log.d("WebSocket", "onDisconnect");
		
	}
	
	public void onStop()
	{
		super.onStop();
		
		mWebSocket.Disconnect();
	}
}
