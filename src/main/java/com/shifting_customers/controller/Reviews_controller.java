package com.shifting_customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_customers.model.Reviews;
import com.shifting_customers.service.Reviews_service;

@RestController
@RequestMapping( path = "/reviews")
public class Reviews_controller {

	@Autowired
	Reviews_service service;
	
	@GetMapping( value = "/getallreviews")
	public List<Reviews> getallreviews(@RequestParam("user_id") long user_id){
		return service.getallreviews(user_id);
	}
	
	
}
 