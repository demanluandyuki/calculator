package com.joyfulmath.calculator.houseloan;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.joyfulmath.calculator.CalculatorFragment;
import com.joyfulmath.calculator.R;

public class HouseLoanFragment extends CalculatorFragment {
	
	private final static int LOAN_INDEX = 0;
	private final static int PREPAYMENT_INDEX = 1;
	private final static int PAYMENT_CONDITION_INDEX = 2;
	
	private ListView mListView = null;
	private HouseLoanAdapter mLoanAdapter = null;
	private int[] ImageId={
		R.drawable.loan_calc,
		R.drawable.loan_manage,
		R.drawable.loan_rates,
	};
	private List<LoanItem> mListItems = new ArrayList<LoanItem>();
			
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setActionBarTitle(getString(R.string.menu_house_loan));
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.houseloan_fragment, null);
		mListView = (ListView) v.findViewById(R.id.list_view_loan);
		ininView();
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
	

	private void ininView() {
		mListItems.clear();
		String[] mString = getResources().getStringArray(R.array.loan_item_array);
		for(int i =0;i<mString.length;i++)
		{
			LoanItem item = new LoanItem();
			item.bitmapRes = ImageId[i];
			item.title = mString[i];
			mListItems.add(item);
		}
		mLoanAdapter = new HouseLoanAdapter(getActivity(), mListItems);
		mListView.setAdapter(mLoanAdapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch(position)
				{
				case LOAN_INDEX:
					Intent intent = new Intent(getActivity(),RealEstatentActivity.class);
					startActivity(intent);
					break;
				case PREPAYMENT_INDEX:
					break;
				case PAYMENT_CONDITION_INDEX:
					break;
				}
			}
			
		});
	}
}
