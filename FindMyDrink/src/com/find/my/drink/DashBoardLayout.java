package com.find.my.drink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DashBoardLayout extends Activity implements OnClickListener{

	Button btSearch,btBlog,btEvents,btCheckin,btAddDrink,btInviteFriends;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		initialize();
		btSearch.setOnClickListener(this);
		btBlog.setOnClickListener(this);
		btEvents.setOnClickListener(this);
		btCheckin.setOnClickListener(this);
		btAddDrink.setOnClickListener(this);
		btInviteFriends.setOnClickListener(this);



	}

	private void initialize() {
		// TODO Auto-generated method stub
		
		btSearch = (Button) findViewById(R.id.btn_search);
		btBlog = (Button) findViewById(R.id.btn_blog);
		btEvents = (Button) findViewById(R.id.btn_events);
		btCheckin = (Button) findViewById(R.id.btn_checkin);
		btAddDrink = (Button) findViewById(R.id.btn_addDrink);
		btInviteFriends = (Button) findViewById(R.id.btn_inviteFriends);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i;
		switch(arg0.getId()){
		
		case R.id.btn_addDrink :
			i = new Intent("com.find.my.drink.AddDrink");
            startActivity(i);

			break;
			
		case R.id.btn_blog:
            i = new Intent("com.find.my.drink.Blog");
            startActivity(i);

            break;
			
		case R.id.btn_checkin:
            i = new Intent("com.find.my.drink.Checkin");
            startActivity(i);

            break;
			
		case R.id.btn_events:
            i = new Intent("com.find.my.drink.Events");
            startActivity(i);

            break;
			
		case R.id.btn_inviteFriends:
            i = new Intent("com.find.my.drink.InviteFriends");
            startActivity(i);

            break;
			
		case R.id.btn_search:
            i = new Intent("com.find.my.drink.Search");
            startActivity(i);

            break;
			
			
		}
		
	}
	

}
