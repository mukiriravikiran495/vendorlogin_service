package com.shifting_customers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table( name = "user_profile")
public class User_profile {
	
	@Id
	@Column( name = "user_id")
	private int user_id;
	
	@Column( name = "email")
	private String email;
	
	@Column( name = "mobilenumber")
	private long mobilenumber;

	@Column( name = "name")
	private String name;
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public User_profile(int user_id, String email, long mobilenumber, String name) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.name = name;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getMobilenumber() {
		return mobilenumber;
	}



	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}



	public User_profile() {
		
	}

}
