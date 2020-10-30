package com.shifting_customers.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table( name = "user_order")
public class User_order {
	
	@Id
	@Column( name = "user_id")
	private int user_id;
	
	@OneToMany( mappedBy = "user_order")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Order_details> order_details;
	
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	

	
	
	@Override
	public String toString() {
		return "User_order [user_id=" + user_id + ", order_details=" + order_details + "]";
	}

	public Set<Order_details> getOrder_details() {
		return order_details;
	}

	public void setOrder_details(Set<Order_details> order_details) {
		this.order_details = order_details;
	}

	
	

	public User_order(int user_id) {
		super();
		this.user_id = user_id;
		
	}

	public User_order() {
		
	}
}
