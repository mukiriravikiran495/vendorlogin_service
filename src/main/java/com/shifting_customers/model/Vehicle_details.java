package com.shifting_customers.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name = "vehicle_details")
public class Vehicle_details {

	@Id
	@Column( name = "vehicle_details_id")
	private int vehicle_details_id;
	
	@Column( name = "vehicle_type")
	private String vehicle_type;
	
	@Column( name = "registration_date")
	private Date registration_date;
	
	@Column( name = "nameOnRC")
	private String nameOnRC;
	
	@Column( name = "vehicle_company")
	private String vehicle_company;
	
	@Column( name = "vehicle_model")
	private String vehicle_model;
	
	
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn( name = "booking_id")
	@JsonBackReference
	private Booking_details booking_details;


	public int getVehicle_details_id() {
		return vehicle_details_id;
	}


	public void setVehicle_details_id(int vehicle_details_id) {
		this.vehicle_details_id = vehicle_details_id;
	}


	public String getVehicle_type() {
		return vehicle_type;
	}


	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}


	public Date getRegistration_date() {
		return registration_date;
	}


	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}


	public String getNameOnRC() {
		return nameOnRC;
	}


	public void setNameOnRC(String nameOnRC) {
		this.nameOnRC = nameOnRC;
	}


	public String getVehicle_company() {
		return vehicle_company;
	}


	public void setVehicle_company(String vehicle_company) {
		this.vehicle_company = vehicle_company;
	}


	public String getVehicle_model() {
		return vehicle_model;
	}


	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}


	public Booking_details getBooking_details() {
		return booking_details;
	}


	public void setBooking_details(Booking_details booking_details) {
		this.booking_details = booking_details;
	}
	
	public Vehicle_details() {
		
	}
}
