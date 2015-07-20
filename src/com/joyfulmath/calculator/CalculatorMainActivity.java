package com.joyfulmath.calculator;

import java.util.ArrayList;
import java.util.List;

import com.joyfulmath.calculator.BottomTabBar.onTabSelectedListener;
import com.joyfulmath.calculator.favorite.FarvoriteFragment;
import com.joyfulmath.calculator.houseloan.HouseLoanFragment;
import com.joyfulmath.calculator.persontax.PersonalTaxFragment;
import com.joyfulmath.calculator.utils.TraceLog;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CalculatorMainActivity extends Activity implements onTabSelectedListener{

	public final static int TAB_FAVORITE_INDEX = 0;
	public final static int TAB_HOUSELOAN_INDEX = 1;
	public final static int TAB_PERSONALTAX_INDEX = 0;

	private int mSelectedTab = TAB_FAVORITE_INDEX;	
	private List<Fragment> mFragments = new ArrayList<Fragment>();
	
	BottomTabBar tabBar = null;
	TextView mTitle = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator_main);
		
		initFragments();
		ViewGroup view = (ViewGroup) findViewById(R.id.bottom_tab);
		tabBar = new BottomTabBar(view, this);
		tabBar.init();
		tabBar.SelectItem(mSelectedTab);
		customActionBar();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	public void customActionBar()
	{
		ActionBar bar = getActionBar();
		if(bar!=null)
		{
			bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
			bar.setCustomView(R.layout.actionbar_layout);
			mTitle = (TextView) bar.getCustomView().findViewById(R.id.action_title);
		}
	}
	
	public void setActionBarTitle(String title)
	{
		TraceLog.i(title);
		if(mTitle!=null)
		{
			mTitle.setText(title);
		}
	}
	
	void initFragments()
	{
		Fragment mFragment = Fragment.instantiate(this, FarvoriteFragment.class.getName(),null);
		Fragment mFragment1 = Fragment.instantiate(this, HouseLoanFragment.class.getName(),null);
		Fragment mFragment2 = Fragment.instantiate(this, PersonalTaxFragment.class.getName(),null);
		mFragments.add(mFragment);
		mFragments.add(mFragment1);
		mFragments.add(mFragment2);
	}

	@Override
	public void onTabSelectedChanged(View view, int index) {
		mSelectedTab = index;		
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.fragment_content, mFragments.get(mSelectedTab));
		ft.commit();
	}
	
}
