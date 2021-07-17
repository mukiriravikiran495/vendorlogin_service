package com.shifting_customers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "estimated_villa_items")
public class Estimated_villa_items {

	
	@Id
	@Column( name = "onebhk_items_id")
	private int onebhk_items_id;
	
	@Column( name = "item_id")
	private int item_id;
	
	@Column( name = "item_type")
	private String item_type;
	
	@Column( name = "item_name")
	private String item_name;
	
	@Column( name = "quantity")
	private int quantity;

	public int getOnebhk_items_id() {
		return onebhk_items_id;
	}

	public void setOnebhk_items_id(int onebhk_items_id) {
		this.onebhk_items_id = onebhk_items_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_type() {
		return item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Estimated_villa_items() {
		
	}
}
