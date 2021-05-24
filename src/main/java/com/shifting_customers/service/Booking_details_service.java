package com.shifting_customers.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shifting_customers.model.Booking_details;
import com.shifting_customers.model.Final_price_details;
import com.shifting_customers.model.Merchant_price_details;
import com.shifting_customers.model.Merchant_profile;


public interface Booking_details_service {

	List<Booking_details> getBookingDetails();

	String createBooking(Booking_details booking_details);

	void deleteBookingById(int id);

	Booking_details findById(int id);

	Booking_details getBookingByBookingId(int id);

	ResponseEntity<Booking_details> cancelBooking(Booking_details booking_details);

	List<Merchant_profile> getmerchantprofiles(String city);

	List<Merchant_price_details> getshift();

	String addbooking_details(Booking_details booking_details);

	String addpricedetails(Final_price_details final_price_details, long booking_id);

	
}
