package com.find.my.drink;

import java.io.InputStream;

//import com.find.my.drink.MainActivity.LoadProfileImage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.IntentSender.SendIntentException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
						//Bundle bundle = new Bundle();
						//bundle.putString("USER_NAME", userName);
						//i.putExtras(bundle);
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
