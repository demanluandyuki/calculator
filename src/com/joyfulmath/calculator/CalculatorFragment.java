package com.joyfulmath.calculator;

import android.app.Fragment;

public class CalculatorFragment extends Fragment {
	
		
	protected void setActionBarTitle(String title)
	{
		CalculatorMainActivity mainActivity = (CalculatorMainActivity) getActivity();
		if(mainActivity !=null )
		{
			mainActivity.setActionBarTitle(title);
		}
	}
}
