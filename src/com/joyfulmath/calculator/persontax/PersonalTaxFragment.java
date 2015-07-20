package com.joyfulmath.calculator.persontax;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joyfulmath.calculator.CalculatorFragment;
import com.joyfulmath.calculator.R;

public class PersonalTaxFragment extends CalculatorFragment {
		
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setActionBarTitle(getString(R.string.menu_personal_tax));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.persontax_fragment, null);
		return v;
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
