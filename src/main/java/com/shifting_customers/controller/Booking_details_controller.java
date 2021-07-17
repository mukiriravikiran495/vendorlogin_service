
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
import com.shifting_customers.model.Estimated_onebhk_items;
import com.shifting_customers.model.Estimated_threebhk_items;
import com.shifting_customers.model.Estimated_twobhk_items;
import com.shifting_customers.model.Estimated_villa_items;
import com.shifting_customers.model.Final_price_details;
import com.shifting_customers.model.House_items;
import com.shifting_customers.model.Merchant_details;
import com.shifting_customers.model.Merchant_price_details;
import com.shifting_customers.model.Merchant_profile;
import com.shifting_customers.model.Selected_items;
import com.shifting_customers.model.User_profile;
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
	
	
	
	@GetMapping( value = "/getshift")
	public List<Merchant_price_details> getshift(){
		List<Merchant_price_details> list = service.getshift();
		
		return list;
	}
	
	@GetMapping( value = "/getonebhkitems")
	public List<Estimated_onebhk_items> getonebhkitems(){
		List<Estimated_onebhk_items> list = service.getonebhkitems();
		return list;
	}
	
	@GetMapping( value = "/gettwobhkitems")
	public List<Estimated_twobhk_items> gettwobhkitems(){
		List<Estimated_twobhk_items> list = service.gettwobhkitems();
		return list;
	}
	
	@GetMapping( value = "/getthreebhkitems")
	public List<Estimated_threebhk_items> getthreebhkitems(){
		List<Estimated_threebhk_items> list = service.getthreebhkitems();
		return list;
	}
	
	@GetMapping( value = "/getvillaitems")
	public List<Estimated_villa_items> getvillaitems(){
		List<Estimated_villa_items> list = service.getvillaitems();
		return list;
	}
	
	@GetMapping( value = "/gethouseitems")
	public List<House_items> gethouseitems(){
		List<House_items> list = service.gethouseitems();
		return list;
	}
	
	@PostMapping( value = "/addonebhkitems", headers ="Accept=application/json")
	public String addonebhkitems(@RequestBody Estimated_onebhk_items items){
		String message = service.addonebhkitems(items);
		return message;
	}
	
	@PostMapping( value = "/addtwobhkitems", headers ="Accept=application/json")
	public String addtwobhkitems(@RequestBody Estimated_twobhk_items items){
		String message = service.addtwobhkitems(items);
		return message;
	}
	
	@PostMapping( value = "/addthreebhkitems", headers ="Accept=application/json")
	public String addthreebhkitems(@RequestBody Estimated_threebhk_items items){
		String message = service.addthreebhkitems(items);
		return message;
	}
	
	@PostMapping( value = "/addvillaitems", headers ="Accept=application/json")
	public String addvillaitems(@RequestBody Estimated_villa_items items){
		String message = service.addvillaitems(items);
		return message;
	}
	
	@PostMapping( value = "/addhouseitems", headers ="Accept=application/json")
	public String addhouseitems(@RequestBody House_items items){
		String message = service.addhouseitems(items);
		return message;
	}
	
	@PostMapping( value = "/addbookingdetails", headers ="Accept=application/json")
	public String addbookingdetails(@RequestBody Booking_details booking_details, long user_id) {
		 String message = service.addbookingdetails(booking_details, user_id);
		 return message;
	}
	
	@PostMapping( value = "/addselecteditems", headers ="Accept=application/json")
	public String addselecteditems(@RequestBody List<Selected_items> selected_items, long booking_id) {
		String message = service.addselecteditems(selected_items, booking_id);
		return message;
		
	}
	
	
	@GetMapping( value = "/getmerchantprofiles")
	public List<Merchant_profile> getmerchantprofiles(@RequestParam("from_location") String city){
		List<Merchant_profile> list = service.getmerchantprofiles(city);
		
		return list;
	}
	
	
	@PostMapping( value = "/completebooking", headers = "Accept=application/json")
	public String completebooking(@RequestBody Final_price_details Final_price_details,@RequestParam("booking_id") long booking_id) {
		String message = service.completebooking(Final_price_details, booking_id);
		return message;
	}
	
	@PostMapping( value = "/addmerchantdetails", headers = "Accept=application/json")
	public String addmerchant_details(@RequestBody Merchant_details merchant_details, @RequestParam("booking_id") long booking_id) {
		String message = service.addmerchant_details(merchant_details, booking_id);
		return message;
	}
	
	@PostMapping( value = "/addmerchant_booking", headers = "Accept=application/json")
	public String addmerchant_booking(@RequestBody Booking_details booking_details, @RequestParam("merchant_id") long merchant_id, @RequestParam("booking_id") long booking_id ) {
		String message = service.addmerchant_booking(booking_details, merchant_id, booking_id);
		return message;
	}
	
	@PutMapping( value = "/updateuserprofile", headers = "Accept=application/json")
	public String updateuserprofile(@RequestBody User_profile user_profile, @RequestParam("booking_id") long booking_id) {
		String message = service.updateuserprofile(user_profile,booking_id);
		return message;
	}
	

	@PutMapping( value = "/cancelbooking", headers ="Accept=application/json")
	public ResponseEntity<String> cancelBooking(@RequestBody Booking_details booking_details, @RequestParam("booking_id") long booking_id){
		String message = service.cancelbooking(booking_details, booking_id);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@GetMapping( value = "/getbookingdetails", headers ="Accept=application/json")
	public Booking_details getbookingdetails(@RequestParam("booking_id") long booking_id) {
		Booking_details details = service.getbookingdetails(booking_id);
		return details;
	}
	
}
