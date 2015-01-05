package com.find.my.drink;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SearchResultsList extends ListActivity {

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d("Search Results", "Inside On Create method");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Log.d("Search Results", "Inside On Create method calling get window");
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		Intent i = getIntent();
		Log.d("Search Results", "Inside On Create method recieveing intent extra drinkName");
		ArrayList<String> drinkName = i.getStringArrayListExtra("drinkName");
		Log.d("Search Results", "Inside On Create method recieveing intent extra desc");
		ArrayList<String> drinkDesc = i.getStringArrayListExtra("drinkDesc");
		Log.d("Search Results", "Inside On Create method recieveing intent extra context ");
		ArrayList<String> drinkContext = i.getStringArrayListExtra("drinkContext");
		Log.d("Search Results", "Inside On Create method recieveing intent extra attr");
		ArrayList<String> drinkAttr = i.getStringArrayListExtra("drinkAttr");
		Log.d("Search Results", "Inside On Create method before setListAdapter");
		setListAdapter(new ArrayAdapter<String>(SearchResultsList.this,android.R.layout.simple_list_item_1,drinkName));
		Log.d("Search Results", "Inside On Create method after setListAdapter");
	}

	
	
}
