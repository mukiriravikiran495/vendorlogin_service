package com.shifting_customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_customers.dao.House_items_dao;
import com.shifting_customers.model.House_items;

@Service("house_items_service")
public class House_items_serviceImpl implements House_items_service{

	@Autowired
	House_items_dao dao;
	
	@Override
	public List<House_items> getItems() {
		return dao.getItems();
	}

}
