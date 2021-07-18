package com.shifting_customers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "house_categories")
public class House_categories {

	@Id
	@Column( name = "house_id")
	public int house_id;
	
	@Column( name = "house_type")
	public String house_type;

	

	public int getHouse_id() {
		return house_id;
	}

	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	public String getHouse_type() {
		return house_type;
	}

	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}
	
	public House_categories() {
		
	}
}
