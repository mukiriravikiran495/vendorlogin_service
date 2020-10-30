package com.shifting_customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_customers.model.House_items;
import com.shifting_customers.service.House_items_service;

@RestController
@RequestMapping( path = "/house_items")
public class House_items_controller {

	@Autowired
	House_items_service service;
	
	@GetMapping( value = "/getitems")
	public List<House_items> getItems(){
		return service.getItems();
	}
}
