package com.find.my.drink;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Gautham_D_N on 1/3/2015.
 */
public class Search extends Activity implements OnClickListener{

	
	ImageView ivSearch ;
	EditText etSearchparam;
	
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.search);
        intialize();
        Log.d("Search", "inside OnCreate method");
        ivSearch.setOnClickListener(this);
        
        

    }

	private void intialize() {
		// TODO Auto-generated method stub
		ivSearch = (ImageView) findViewById(R.id.ivSearchButton);
		etSearchparam = (EditText) findViewById(R.id.etSearchDrink);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d("Search", "inside OnClick method");
		switch(v.getId()){
		 
		case R.id.ivSearchButton:
			Log.d("Search", "inside OnClick method - search button case");
			ArrayList<Drink> drink = new ArrayList<Drink>();
			DatabaseHandler db = new DatabaseHandler(this);
			Log.d("Search", "before calling gt all drinks by name");
			drink = db.getAllDrinksByName(etSearchparam.getText().toString());
			Log.d("Search", "after calling gt all drinks by name");
			
			if(drink.get(0).getName()!="No Drink Exists") {
				Log.d("Search", "inside if drinks found ");
			ArrayList<String> drinkName = new ArrayList<String>();
			ArrayList<String> drinkDesc = new ArrayList<String>();
			ArrayList<String> drinkContext = new ArrayList<String>();
			ArrayList<String> drinkAttr = new ArrayList<String>();
			
			for( int i = 0; i< drink.size(); i++)
			{
				drinkName.add(drink.get(i).getName().toString());
				drinkDesc.add(drink.get(i).getDesc().toString());
				drinkContext.add(drink.get(i).getContext().toString());
				drinkAttr.add(drink.get(i).getAttributes().toString());
			}
			
			Log.d("Search", "before intent of searchResllts list found ");
			Intent i = new Intent("com.find.my.drink.SEARCHRESULTSLIST");
			Bundle b = new Bundle();
			b.putStringArrayList("drinkName", drinkName);
			b.putStringArrayList("drinkDesc", drinkDesc);
			b.putStringArrayList("drinkContext", drinkContext);
			b.putStringArrayList("drinkAttr", drinkAttr);
			i.putExtras(b);
			Log.d("Search", "before intent of searchResllts START ACTIVITY ");
			startActivity(i);
			}
			else{
				Log.d("Search", "inside else drinks not found ");
				Toast.makeText(this, "No Drink Found", Toast.LENGTH_LONG).show();

			}
			
			break;
		
		}
		
	}
}
