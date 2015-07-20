package com.joyfulmath.calculator.houseloan;

import java.util.List;

import com.joyfulmath.calculator.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HouseLoanAdapter extends BaseAdapter {

	List<LoanItem> mList = null;
	private final LayoutInflater mInflater;
		
	public HouseLoanAdapter(Context context,List<LoanItem> list)
	{
		mInflater = LayoutInflater.from(context);
		mList = list;
	}
	
	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mList.get(position).hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LoanViewHolder holder;
		if(convertView!=null)
		{
			holder = (LoanViewHolder) convertView.getTag();
		}
		else
		{
			holder = new LoanViewHolder();
			convertView = mInflater.inflate(R.layout.list_simple_textview, null);
			holder.imgView = (ImageView) convertView.findViewById(R.id.img_head);
			holder.titleView = (TextView) convertView.findViewById(R.id.text_title);
			convertView.setTag(holder);
		}
		LoanItem item = mList.get(position);
		
		if(item.bitmapRes>0)
		{
			holder.imgView.setImageResource(item.bitmapRes);
			holder.imgView.setVisibility(View.VISIBLE);
		}
		else
		{
			holder.imgView.setVisibility(View.GONE);
		}
		
		holder.titleView.setText(item.title);
		
		return convertView;
	}
	
	public static class LoanViewHolder {
		TextView titleView;
		ImageView imgView;
	}

}
