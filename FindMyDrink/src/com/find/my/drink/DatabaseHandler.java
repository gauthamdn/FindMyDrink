package com.find.my.drink;

import java.sql.Date;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper{

	
	private static final int DATABASE_VERSION = 3;
	private static final String DATABASE_NAME ="drinkdatabase";
	
	//Users Table
	private static final String TABLE_USERS ="user";
	private static final String KEY_USERS_UID = "uid";
	private static final String KEY_USERS_NAME = "name";
	private static final String KEY_USERS_EMAIL = "email";
	private static final String KEY_USERS_FAVDRINK = "favouritedrink";
	private static final String KEY_USERS_CITY = "city";
	private static final String KEY_USERS_CREATE_DATE = "creationdate";
	
	
	//Drink table
	private static final String TABLE_DRINK ="drink";
	private static final String KEY_DRINK_ID = "drinkid";
	private static final String KEY_DRINK_NAME = "drinkname";
	private static final String KEY_DRINK_CONTEXT = "context";
	private static final String KEY_DRINK_DESC = "drinkdescription";
	private static final String KEY_DRINK_ATTR = "attributes";
	private static final String KEY_DRINK_CREATE_DATE = "creationdate";
	
	//Drink Attribute table
	private static String TABLE_DRINK_ATTR ="drinkattributes";
	private static final String KEY_DRINK_ATTR_ID = "attrid";
	private static final String KEY_DRINK_ATTR_NAME = "attrname";
	private static final String KEY_DRINK_ATTR_DESC = "attrdesc";	
	private static final String KEY_DRINK_ATTR_CREATE_DATE = "creationdate";
	
	private static String TABLE_DRINK_ATTR_REL ="drinkattributesrel";
	private static final String KEY_DRINK_ATTR_REL_ATTRID = "attrid";
	private static final String KEY_DRINK_ATTR_REL_DRINKID = "drinkid";
	private static final String KEY_DRINK_ATTR_REL_CREATE_DATE = "creationdate";
		
	public DatabaseHandler(Context context) {
		// TODO Auto-generated constructor stub
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		
		Log.d("DatabaseHandler:","Inside OnCreate of DatabaseHandler");
		String CREATE_TABLE_USERS = " CREATE TABLE "+ TABLE_USERS+ " ("
				+ KEY_USERS_UID + " INTEGER PRIMARY KEY,"
				+ KEY_USERS_NAME + " TEXT, "
				+ KEY_USERS_EMAIL + " TEXT, "
				+ KEY_USERS_CITY + " TEXT, "				
				+ KEY_USERS_CREATE_DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
				+ KEY_USERS_FAVDRINK+ " TEXT )";
	
		String CREATE_TABLE_DRINK = " CREATE TABLE "+ TABLE_DRINK+ " ("
								+ KEY_DRINK_ID + " INTEGER PRIMARY KEY,"
								+ KEY_DRINK_NAME + " TEXT, "
								+ KEY_DRINK_CONTEXT + " TEXT, "
								+ KEY_DRINK_ATTR + " TEXT, "
								+ KEY_DRINK_CREATE_DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
								+ KEY_DRINK_DESC+ " TEXT )";
				
		String CREATE_TABLE_DRINK_ATTR = " CREATE TABLE "+ TABLE_DRINK_ATTR+ " ("
				+ KEY_DRINK_ATTR_ID + " INTEGER PRIMARY KEY,"
				+ KEY_DRINK_ATTR_NAME + " TEXT, "
				+ KEY_DRINK_ATTR_DESC + " TEXT, "								
				+ KEY_DRINK_ATTR_CREATE_DATE+ " DATETIME DEFAULT CURRENT_TIMESTAMP )";
		
		String CREATE_TABLE_DRINK_ATTR_REL = " CREATE TABLE "+ TABLE_DRINK_ATTR_REL+ " ("
				+ KEY_DRINK_ATTR_REL_ATTRID + " INTEGER PRIMARY KEY,"
				+ KEY_DRINK_ATTR_REL_DRINKID + " TEXT, "											
				+ KEY_DRINK_ATTR_REL_CREATE_DATE+ " DATETIME DEFAULT CURRENT_TIMESTAMP )";

		Log.d("DatabaseHandler:","Inside OnCreate of DatabaseHandler and creating tables");
		db.execSQL(CREATE_TABLE_USERS);
		db.execSQL(CREATE_TABLE_DRINK);
		db.execSQL(CREATE_TABLE_DRINK_ATTR);
		db.execSQL(CREATE_TABLE_DRINK_ATTR_REL);	
		
		Log.d("DatabaseHandler:","Inside OnCreate done creating tables");
		
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.d("DatabaseHandler:","Inside OnUpgrade of DatabaseHandler and droping tables");
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_USERS);
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_DRINK);
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_DRINK_ATTR);
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_DRINK_ATTR_REL);
		
		Log.d("DatabaseHandler:","Inside OnUpgrade of DatabaseHandler and calling onCreate");
		onCreate(db);
		
	}
	
	
	/* CRUD methods on User */
	
	
	
	public void addUser(User user){
		
		SQLiteDatabase db = this.getWritableDatabase();


		ContentValues values = new ContentValues();
		values.put(KEY_USERS_NAME, user.getName());
		values.put(KEY_USERS_EMAIL, user.getEmail());
		values.put(KEY_USERS_FAVDRINK, user.getFavDrink());
		values.put(KEY_USERS_CITY, user.getCity());
		
		db.insert(TABLE_USERS, null, values);
		db.close();

		
	}
	
	public String checkUserExists(){		
		SQLiteDatabase db = this.getReadableDatabase();
		
		//String[] columns = {KEY_USERS_UID,KEY_USERS_NAME,KEY_USERS_EMAIL,KEY_USERS_FAVDRINK,KEY_USERS_CREATE_DATE};
		
		String selectQuery = "SELECT * FROM "+TABLE_USERS;
		Cursor cursor = db.rawQuery(selectQuery, null);
		Log.d("DatabaseHandler", " before nullcheck on cursor");
		if(cursor.getCount() != 0){
			Log.d("DatabaseHandler", " cursor is not null ");
			cursor.moveToFirst();
			Log.d("DatabaseHandler", " cursor before return id1 = "+cursor.getString(0));
			Log.d("DatabaseHandler", " cursor before return id2 = "+cursor.getString(1));
			Log.d("DatabaseHandler", " cursor before return id3 = "+cursor.getString(3));
			return cursor.getString(1).toString();
		}else{
			Log.d("DatabaseHandler", " cursor is null baby");
			return "No User Exists";
		}
			
		
		//Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, groupBy, having, orderBy)		
	}
	
	public User getUserById(int id){		
		return null;
		
	}
	
	public <List>User getUserListByName(String name){		
		return null;
		
	}
	
	public <List>User getUserListByFavDrink(String favDrink){		
		return null;
		
	}
	
	public <List>User getUserListByCity(String city){		
		return null;
		
	}
	
	public <List>User getUserListByEmail(String email){		
		return null;
		
	}
	
	public <List>User getUserListByCreateDate(Date date){		
		return null;
		
	}
		
	
	public int updateUser(User user){		
			return 0; 
		
	}
	
	public void removeUser(int id){
		
	}
	
	
	public void addDrink(Drink drink){
		
		
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_DRINK_NAME, drink.getName());
		values.put(KEY_DRINK_CONTEXT, drink.getContext());
		values.put(KEY_DRINK_DESC, drink.getDesc());
		values.put(KEY_DRINK_ATTR, drink.getAttributes());
		
		db.insert(TABLE_DRINK, null, values);
		db.close();


	}
	
	public Drink checkDrinkExists(Drink drink){
		return null;
	}
	
	public Drink getDrinkById(int id){
		return null;
	}

	public <List>ArrayList<Drink> getAllDrinksByName(String name){
		
		
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Drink> listOfDrinks = new ArrayList<Drink>();
				
		String[] args = new String[1];
		args[0] = "%"+name+"%";
		Log.d("DatabaseHandler", " forming query");
		String selectQuery = "SELECT * FROM "+TABLE_DRINK+" WHERE UPPER("+ KEY_DRINK_NAME + ") like ?";
		
		Log.d("DatabaseHandler", " invoking query");
		Cursor cursor = db.rawQuery(selectQuery, args);
		
		
		Log.d("DatabaseHandler", " before nullcheck on cursor");
		if(cursor.getCount() != 0 && cursor.moveToFirst()){
			Log.d("DatabaseHandler", " cursor is not null ");
			
			do{
	
				Drink drink = new Drink();	
				//drink.id = cursor.getInt(0);
				drink.name = cursor.getString(1);
				drink.context = cursor.getString(2);
				drink.attributes = cursor.getString(3);
				drink.desc = cursor.getString(5);
				Log.d("DatabaseHandler", " iterating through the cursor "+cursor.getString(1));
				listOfDrinks.add(drink);
				Log.d("DatabaseHandler", " adding to list of drinks "+cursor.getString(1));
				drink=null;
				
			}while(cursor.moveToNext());
			
			cursor.close();
			Log.d("DatabaseHandler", " closing cursor and returning  ");
			return listOfDrinks;
		}else{
			Log.d("DatabaseHandler", " cursor is null baby");
			Drink drink = new Drink();
			drink.name =  "No Drink Exists";
			Log.d("DatabaseHandler", " added no drink exists to drink");
			listOfDrinks.add(drink);
			cursor.close();
			Log.d("DatabaseHandler", "closed cursor and returning list of empty drinks");
			return listOfDrinks;
		}
		
	}
	
	
	public <List>Drink getAllDrinksByAttributes(String attr){
		return null;
	}
	
	public <List>Drink getAllDrinksByDesc(String desc){
		return null;
	}
	
	
	public <List>Drink getAllDrinksByCreateDate(Date date){
		return null;
	}
	
		
	public void removeDrink(Drink drink){
		
	}
	
	

}
