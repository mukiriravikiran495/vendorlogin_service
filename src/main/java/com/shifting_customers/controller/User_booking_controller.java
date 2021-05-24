package com.shifting_customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_customers.model.User_booking;

import com.shifting_customers.service.User_booking_service;

@RestController
@RequestMapping( path = "/user_order")
public class User_booking_controller {

	@Autowired
	User_booking_service service;
	
	@GetMapping( value = "/getorders")
	public List<User_booking> getorders(){
		return service.getbookings();
	}
	
	@PostMapping( value = "/placeorder",  headers="Accept=application/json")
	public ResponseEntity<String> placeOrder(@RequestBody User_booking user_booking) {
		String message =  service.placeorder(user_booking);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping( value = "/{id}")
	public List<User_booking> getallBookingsbyUser_id(@PathVariable int id){
		return service.getallBookingsbyUser_id(id);
	}
}
