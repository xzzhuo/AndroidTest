package com.example.androidtest;

import android.app.Fragment;
import android.content.Context;

public class BaseFragment extends Fragment {

	interface OnCreateListener
	{
		public void onCreate();
	}
	
	protected Context mContext;
	protected OnCreateListener mListener;
	
	public BaseFragment(Context context, OnCreateListener listener)
	{
		this.mContext = context;
		this.mListener = listener;
	}
}
