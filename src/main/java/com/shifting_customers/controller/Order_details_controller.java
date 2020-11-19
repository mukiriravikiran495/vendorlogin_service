package com.shifting_customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_customers.model.Order_details;
import com.shifting_customers.service.Order_details_service;

@RestController
@RequestMapping( path = "/order_details")
public class Order_details_controller {
	
	@Autowired
	Order_details_service service;
	
	@GetMapping( value = "/get") // get all records
	public List<Order_details> getOrderDetails(){
		return service.getOrderDetails();
	}

	@GetMapping( value = "/{id}") 
	public Order_details getOrderByOrderId(@PathVariable("id") int id) {
		
		return service.getOrderByOrderId(id);
		
	}
	
	
	// delete an order
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<Order_details> deleteUser(@PathVariable("id") int id){
		Order_details user = service.findById(id);
		if (user == null) {
			return new ResponseEntity<Order_details>(HttpStatus.NOT_FOUND);
		}
		service.deleteOrderById(id);
		return new ResponseEntity<Order_details>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	@PutMapping( value = "/cancelorder")
	public ResponseEntity<Order_details> cancelOrder(@RequestBody Order_details order_details){
		
		return service.cancelOrder(order_details);
	}
	
	//change status to cancel
	
	
	
	
	
}
