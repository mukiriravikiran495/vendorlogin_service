package com.shifting_customers.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table( name = "order_details")
public class Order_details {

	@Id
	@Column( name = "order_id")
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int order_id;
	
	@Column( name = "from_location")
	private String from_location;
	
	@Column( name = "to_location")
	private String to_location;
	
	@Column( name = "house_type")
	private String house_type;
	
	private Status status = Status.Requested;
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@OneToOne( mappedBy = "order_details")
	private From_house_details from_house_details;
	
	@OneToOne( mappedBy = "order_details")
	private To_house_details to_house_details;
	
	
	@OneToMany( mappedBy = "order_details",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Selected_items> selected_items;
	
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn( name = "user_id")
	@JsonBackReference
	private User_order user_order;

	
	public String getHouse_type() {
		return house_type;
	}

	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}

	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getFrom_location() {
		return from_location;
	}

	public String setFrom_location(String from_location) {
		 return this.from_location = from_location;
	}

	public String getTo_location() {
		return to_location;
	}

	public void setTo_location(String to_location) {
		this.to_location = to_location;
	}

	public From_house_details getFrom_house_details() {
		return from_house_details;
	}

	public void setFrom_house_details(From_house_details from_house_details) {
		this.from_house_details = from_house_details;
	}

	public To_house_details getTo_house_details() {
		return to_house_details;
	}

	public void setTo_house_details(To_house_details to_house_details) {
		this.to_house_details = to_house_details;
	}

	public Set<Selected_items> getSelected_items() {
		return selected_items;
	}

	public void setSelected_items(Set<Selected_items> selected_items) {
		this.selected_items = selected_items;
	}

	public User_order getUser_order() {
		return user_order;
	}

	public void setUser_order(User_order user_order) {
		this.user_order = user_order;
	}

	

	

	

	

	public Order_details(int order_id, String from_location, String to_location, String house_type, Status status,
			From_house_details from_house_details, To_house_details to_house_details, User_order user_order) {
		super();
		this.order_id = order_id;
		this.from_location = from_location;
		this.to_location = to_location;
		this.house_type = house_type;
		this.status = status;
		this.from_house_details = from_house_details;
		this.to_house_details = to_house_details;
		this.user_order = user_order;
	}

	
	@Override
	public String toString() {
		return "Order_details [order_id=" + order_id + ", from_location=" + from_location + ", to_location="
				+ to_location + ", house_type=" + house_type + ", status=" + status + ", from_house_details="
				+ from_house_details + ", to_house_details=" + to_house_details + ", user_order=" + user_order + "]";
	}

	public Order_details() {
		
	}
	
}
