package com.find.my.drink;

import java.sql.Date;

public class User {

	int id;
	String name, email, favDrink,city;
	Date createDate;
	
	public User(){
		//empty constructor		
	}
	
	public User(int id, String name, String email, String favDrink,String city) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.favDrink = favDrink;
		this.city = city;
	}

	public User( String name, String email, String favDrink,String city) {			
		this.name = name;
		this.email = email;
		this.favDrink = favDrink;
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFavDrink() {
		return favDrink;
	}
	public void setFavDrink(String favDrink) {
		this.favDrink = favDrink;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	
}
