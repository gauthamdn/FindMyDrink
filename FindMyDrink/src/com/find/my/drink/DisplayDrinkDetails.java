package com.find.my.drink;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DisplayDrinkDetails extends Activity{

	
	TextView dName, dDesc, dCategory, dAttr;
	String drinkName, drinkDesc,drinkContext, drinkAttr;
	
	@Override
	public void onCreate(Bundle b) {
		// TODO Auto-generated method stub
		super.onCreate(b);
		setContentView(R.layout.displaydrinkdetails);
		initialize();
		
		Intent i = getIntent();
		
		drinkName = i.getStringExtra("drinkName");
		dName.setText(drinkName);
		Log.d("Search Results", "Inside On Create method recieveing intent extra desc");
		drinkDesc = i.getStringExtra("drinkDesc");
		dDesc.setText(drinkDesc);
		Log.d("Search Results", "Inside On Create method recieveing intent extra context ");
		drinkContext = i.getStringExtra("drinkContext");
		dCategory.setText(drinkContext);
		Log.d("Search Results", "Inside On Create method recieveing intent extra attr");
		drinkAttr = i.getStringExtra("drinkAttr");
		dAttr.setText(drinkAttr);
		Log.d("Search Results", "Inside On Create method before setListAdapter");
		
		
		
	}

	private void initialize() {
		// TODO Auto-generated method stub
		
		dName = (TextView) findViewById(R.id.tvDrinkName);
		dDesc = (TextView) findViewById(R.id.tvDrinkDesc);
		dCategory = (TextView) findViewById(R.id.tvDrinkCategory);
		dAttr = (TextView) findViewById(R.id.tvDrinkAttributes);
		
		
	}
	
	

}
