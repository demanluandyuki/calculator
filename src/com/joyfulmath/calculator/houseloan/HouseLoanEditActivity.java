/***********************************************************

 *@description : This class function is TODO 

 *

 * @create author : deman.lu

 * @create date   :2015-07-15

 * @modify author :

 * @modify date   :

 * @contact: joyfulmath.china@gmail.com

 *

 **********************************************************/
package com.joyfulmath.calculator.houseloan;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.TextView;

import com.joyfulmath.calculator.CalculaterBaseActivity;
import com.joyfulmath.calculator.R;

public class HouseLoanEditActivity extends CalculaterBaseActivity {

		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.houseloan_edit_layout);
		customerActionBar();
		initView();
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
	
	/**
	 * 
	 * @description :custom define action bar
	 * 
	 * @author :	deman.lu
	 * 
	 * @create :	2015-07-21
	 * 
	 * @return :	void
	 */
	protected void customerActionBar() {
		ActionBar actionbar = this.getActionBar();
		if (null != actionbar) {
			actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
			actionbar.setCustomView(R.layout.actionbar_layout);
			TextView title = (TextView) actionbar.getCustomView().findViewById(R.id.action_title);
			title.setText(R.string.realestatent_loan);
		}
	}
	
	private void initView() {
		
	}
}
