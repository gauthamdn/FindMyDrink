package com.find.my.drink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DashBoard extends Activity{

	TextView dashBoardUser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		
		
		Log.d("Dashboard: ", "Inside dashboard") ; 
		dashBoardUser = (TextView) findViewById(R.id.tv_dashboard_user);
		dashBoardUser.setText("Inside dashboard");
		
	
		Bundle bundle = getIntent().getExtras();
		
		if(bundle.getString("USER_NAME").toString().length()>0){
			Log.d("Dashboard: ", "Inside if condition");
			dashBoardUser.setText(bundle.getString("USER_NAME").toString());
		}
		else{ 
			Log.d("Dashboard: ", "Inside else condition");
			dashBoardUser.setText("Invalid user");
		}	
	}
	

}
