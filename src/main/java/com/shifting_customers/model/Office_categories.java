package com.shifting_customers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "office_categories")
public class Office_categories {

	
	@Id
	@Column( name = "office_id")
	public int office_id;
	
	@Column( name = "office_categeoty")
	public String office_category;

	

	public int getOffice_id() {
		return office_id;
	}

	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}

	public String getOffice_category() {
		return office_category;
	}

	public void setOffice_category(String office_category) {
		this.office_category = office_category;
	}
	
	public Office_categories() {
		
	}
	
}
