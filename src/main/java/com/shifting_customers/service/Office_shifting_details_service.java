package com.shifting_customers.service;

import java.util.List;

import com.shifting_customers.model.Office_shifting_details;

public interface Office_shifting_details_service {

	public List<Office_shifting_details> getalllist();

	public String create(Office_shifting_details office_shifting_details);
		

}
