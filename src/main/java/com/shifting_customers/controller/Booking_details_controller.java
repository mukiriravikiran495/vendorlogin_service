
package com.shifting_customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_customers.model.Booking_details;
import com.shifting_customers.model.Final_price_details;
import com.shifting_customers.model.Merchant_price_details;
import com.shifting_customers.model.Merchant_profile;
import com.shifting_customers.service.Booking_details_service;

@RestController
@RequestMapping( path = "/booking_details")
public class Booking_details_controller {
	
	@Autowired
	Booking_details_service service;
	
	@GetMapping( value = "/get/getall") // get all records
	public List<Booking_details> getOrderDetails(){
		return service.getBookingDetails();
	}

	@GetMapping( value = "/{id}") 
	public Booking_details getOrderByOrderId(@PathVariable("id") int id) {
		
		return service.getBookingByBookingId(id);
		
	}
	
	
	// delete an order
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<Booking_details> deleteUser(@PathVariable("id") int id){
		Booking_details user = service.findById(id);
		if (user == null) {
			return new ResponseEntity<Booking_details>(HttpStatus.NOT_FOUND);
		}
		service.deleteBookingById(id);
		return new ResponseEntity<Booking_details>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	@PutMapping( value = "/house_order_details/cancelorder")
	public ResponseEntity<Booking_details> cancelOrder(@RequestBody Booking_details booking_details){
		
		return service.cancelBooking(booking_details);
	}
	
	@GetMapping( value = "/getmerchantprofiles")
	public List<Merchant_profile> getmerchantprofiles(@RequestParam("from_location") String city){
		List<Merchant_profile> list = service.getmerchantprofiles(city);
		
		return list;
	}
	
	@GetMapping( value = "/getshift")
	public List<Merchant_price_details> getshift(){
		List<Merchant_price_details> list = service.getshift();
		
		return list;
	}
	
	@PostMapping( value = "/addbooking_details", headers ="Accept=application/json")
	public ResponseEntity<String> addbooking_details(@RequestBody Booking_details booking_details){
		String message = service.addbooking_details(booking_details);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@PostMapping( value = "/addpricedetails", headers ="Accept=application/json")
	public ResponseEntity<String> addpricedetails(@RequestBody Final_price_details final_price_details, @RequestParam("booking_id") long booking_id){
		String message = service.addpricedetails(final_price_details, booking_id);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
}
