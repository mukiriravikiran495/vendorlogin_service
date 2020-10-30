package com.shifting_customers.dao;

import java.util.List;

import com.shifting_customers.model.Office_shifting_details;

public interface Office_shifting_details_dao {

	List<Office_shifting_details> getalllist();

	String create(Office_shifting_details office_shifting_details);

}
