package com.shifting_customers.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name = "selected_items")
public class Selected_items {
	
	@Id
	@Column( name = "selected_items_id")
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int selected_items_id;
	
	@Column( name = "item")
	private String item;
	
	@Column( name = "quantity")
	private int quantity;
	
	@Column( name = "item_type")
	private String item_type;
	
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn( name = "order_id")
	@JsonBackReference
	private Order_details order_details;
	

	public Order_details getOrder_details() {
		return order_details;
	}


	public void setOrder_details(Order_details order_details) {
		this.order_details = order_details;
	}


	public int getSelected_items_id() {
		return selected_items_id;
	}


	public void setSelected_items_id(int selected_items_id) {
		this.selected_items_id = selected_items_id;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getItem_type() {
		return item_type;
	}


	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}


	public Selected_items() {
		
	}
}
