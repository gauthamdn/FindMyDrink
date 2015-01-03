package com.find.my.drink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 


public class RegisterActivity extends Activity implements OnClickListener {
	
	
	TextView loginScreen;
	Button registerBtn;
	EditText etName,etEmail,etFavDrink,etCity;
	
	
	public void initialize(){
		
		Log.d("RegisterActivity", "inside init");
		loginScreen = (TextView) findViewById(R.id.link_to_login);
        registerBtn = (Button) findViewById(R.id.btnRegister);
        etName = (EditText) findViewById(R.id.et_reg_fullname);
        etEmail = (EditText) findViewById(R.id.et_reg_email);
        etFavDrink = (EditText) findViewById(R.id.et_reg_favdrink);
        etCity = (EditText) findViewById(R.id.et_reg_city);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.register);
        Log.d("RegisterActivity", "inside onCreate");
        initialize();
        Log.d("RegisterActivity", "after init");
        
        registerBtn.setOnClickListener(this);
        loginScreen.setOnClickListener(this);

    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Log.d("RegisterActivity", "inside onClick arg0 vaue is: " + arg0.getId());
		
		switch(arg0.getId()){
		
		case R.id.btnRegister:
			Log.d("RegisterActivity", "inside case btnRegister");
			DatabaseHandler db = new DatabaseHandler(this);
			User user = new User(etName.getText().toString(),etEmail.getText().toString(),etFavDrink.getText().toString(),etCity.getText().toString());
			db.addUser(user);
			Intent i = new Intent("com.find.my.drink.DASHBOARD");
			Bundle bundle = new Bundle();
			bundle.putString("USER_NAME", etName.getText().toString());
			i.putExtras(bundle);
			startActivity(i);
			break;
			
		case R.id.link_to_login:
			Log.d("RegisterActivity", "inside case linktologin");
			finish();
			break;
		
		}
		
	}
}