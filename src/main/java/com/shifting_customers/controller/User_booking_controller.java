package com.shifting_customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_customers.model.Booking_details;
import com.shifting_customers.service.User_booking_service;

@RestController
@RequestMapping( path = "/user_booking")
public class User_booking_controller {

	@Autowired
	User_booking_service service;
	
	
	@GetMapping( value = "/getallbookings")
	public List<Booking_details> getbookings(@RequestParam("user_id") long user_id){
		List<Booking_details> list = service.getBookings(user_id);
		return list;
		
	}
	
	
	public Booking_details getbookingdetails(@RequestParam long booking_id) {
		Booking_details details = service.getbookingdetails(booking_id);
		return details;
	}
}
