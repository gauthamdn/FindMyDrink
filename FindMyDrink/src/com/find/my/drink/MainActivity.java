package com.find.my.drink;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;
import android.content.Context;
import android.util.Log;

public class MainActivity extends Activity {

	String userName ;
	TextView dashBoardUser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final DatabaseHandler db = new DatabaseHandler(this);
		
		Thread timer = new Thread(){
			
			public void run(){
				
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
										
					Log.d("MainActivity", " before Invoking checkUserExists");
					userName = db.checkUserExists();
					Log.d("MainActivity", " Invoked checkUserExists and username is"+userName);
					//userName ="No User Exists";
					
					if(userName.contentEquals("No User Exists")) {
					Intent i = new Intent("com.find.my.drink.LOGINACTIVITY");
					startActivity(i);
					}
					else{
						//dashBoardUser.setText(userName);
						Intent i = new Intent("com.find.my.drink.DASHBOARD");
						Bundle bundle = new Bundle();
						bundle.putString("USER_NAME", userName);
						i.putExtras(bundle);
						startActivity(i);
					}
						
				}
			}
			
		};
		
		timer.start();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
