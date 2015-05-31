package com.joyfulmath.calculator;

import java.util.HashMap;
import java.util.Iterator;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class BottomTabBar implements OnClickListener{
	
	ViewGroup mLayoutView;
	onTabSelectedListener mListener;
	HashMap<Integer, View> mViewCache = new HashMap<Integer, View>();
	int mSelectedTab = -1;
	
	public BottomTabBar(ViewGroup view, onTabSelectedListener listener)
	{
		if(null == view)
		{
			throw new RuntimeException("BottomTabBar():view is null");
		}
				
		mLayoutView = view;
		mListener = listener;
		mViewCache.clear();
	}	
	
	/*
	 * index
	 * */
	public void SelectItem(int index)
	{
		if(mSelectedTab ==index)
		{
			return;
		}
		mSelectedTab = index;
		
		View v = null;
		if(mViewCache.containsKey(index))
		{
			v = mViewCache.get(index);
			v.setSelected(true);
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}		
		
		Iterator<Integer> iterator = mViewCache.keySet().iterator();
		while(iterator.hasNext())
		{
			int key = iterator.next();
			if(key != index)
			{
				mViewCache.get(key).setSelected(false);
			}
		}
		if(null!= mListener)
		{
			mListener.onTabSelectedChanged(v, index);
		}
	}
	
	
	public void init()
	{
		mViewCache.clear();
		int count = mLayoutView.getChildCount();
		View v = null;
		for(int i=0;i<count;i++)
		{
			v = mLayoutView.getChildAt(i);
			v.setTag(i);
			mViewCache.put(i, v);
			v.setOnClickListener(this);
		}
	}
	
	public void release()
	{
		mViewCache.clear();
	}

	@Override
	public void onClick(View v) {
		int index = (Integer) v.getTag();
		SelectItem(index);
	}
	
	public interface onTabSelectedListener {
		
		/* function on tab selected
		 * @param view
		 * @param index  id of view
		 * */
		void onTabSelectedChanged(View view,int index);
	}
}
