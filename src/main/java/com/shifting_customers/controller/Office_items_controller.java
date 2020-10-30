package com.shifting_customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_customers.model.Office_items;
import com.shifting_customers.service.Office_items_service;

@RestController
@RequestMapping( path = "/office_items")
public class Office_items_controller {

	@Autowired
	Office_items_service service;
	
	@GetMapping( value = "/getitems")
	public List<Office_items> getItems(){
		return service.getItems();
	}
	
}
