package com.shifting_customers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Vehicle_categories")
public class Vehicle_categories {

	@Id
	@Column( name = "vehicle_id")
	public int vehicle_id;
	
	@Column( name = "vehicle_type")
	public String vehicle_type;
	
	@Column( name = "quantity")
	public int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	
	public Vehicle_categories() {
		
	}
	
	
	 
}
