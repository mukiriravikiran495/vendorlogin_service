package com.shifting_customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_customers.dao.Office_items_dao;
import com.shifting_customers.model.Office_items;

@Service("office_items_service")
public class Office_items_serviceImpl implements Office_items_service{

	@Autowired
	Office_items_dao dao;
	
	@Override
	public List<Office_items> getItems() {
		return dao.getItems();
	}

}
