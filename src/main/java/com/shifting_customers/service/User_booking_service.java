package com.shifting_customers.service;

import java.util.List;

import com.shifting_customers.model.Booking_details;


public interface User_booking_service {

	
	List<Booking_details> getBookings(long user_id);

	Booking_details getbookingdetails(long booking_id);

	
}
