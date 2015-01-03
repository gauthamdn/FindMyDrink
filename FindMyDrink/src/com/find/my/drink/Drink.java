package com.find.my.drink;

import java.sql.Date;

public class Drink {

	int id;
	String name, context, desc,attributes;
	Date createDate;
	
	public Drink(){
		//empty Constructor
		
	}
	
	public Drink(int id, String name, String context, String desc,
			String attributes) {
		super();
		this.id = id;
		this.name = name;
		this.context = context;
		this.desc = desc;
		this.attributes = attributes;
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	
	
}
