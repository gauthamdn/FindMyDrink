package com.find.my.drink;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

/**
 * Created by Gautham_D_N on 1/3/2015.
 */
public class AddDrink extends Activity implements OnClickListener{

	EditText etDrinkName, etDesc, etCategory, etAttribute;
	Button bRegister;
	
	public void initialize(){
		
		etDrinkName = (EditText) findViewById(R.id.etDrinkName);
		etDesc = (EditText) findViewById(R.id.etDrinkDesc);
		etCategory = (EditText) findViewById(R.id.etDrinkCategory);
		etAttribute = (EditText) findViewById(R.id.etDrinkAttributes);		
		bRegister = (Button) findViewById(R.id.btn_DrinkRegister);
	}
	
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.add_drink);
        initialize();
        
        bRegister.setOnClickListener(this);
       

    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		
		case R.id.btn_DrinkRegister:
			
			DatabaseHandler db = new DatabaseHandler(this);
			Drink drink = new Drink(etDrinkName.getText().toString(),etCategory.getText().toString(),etDesc.getText().toString(),etAttribute.getText().toString());
			db.addDrink(drink);
			
			Toast.makeText(this, etDrinkName.getText().toString()+" Added!", Toast.LENGTH_LONG).show();
			etDesc.setText("");
			etCategory.setText("");
			etAttribute.setText("");
			
			break;
			
		}
		
	}
}
