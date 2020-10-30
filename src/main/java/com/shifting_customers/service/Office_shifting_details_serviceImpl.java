package com.shifting_customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_customers.dao.Office_shifting_details_dao;
import com.shifting_customers.model.Office_shifting_details;

@Service("Office_shifting_details_service")
public class Office_shifting_details_serviceImpl implements Office_shifting_details_service{

	@Autowired
	Office_shifting_details_dao dao;
	
	@Override
	public List<Office_shifting_details> getalllist() {
		// TODO Auto-generated method stub
		return dao.getalllist();
	}

	@Override
	public String create(Office_shifting_details office_shifting_details) {
		// TODO Auto-generated method stub
		return dao.create(office_shifting_details);
	}

}
