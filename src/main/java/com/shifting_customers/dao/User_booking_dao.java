package com.shifting_customers.dao;

import java.util.List;

import com.shifting_customers.model.Booking_details;

public interface User_booking_dao {

	
	List<Booking_details> getbookings(long user_id);

	Booking_details getbookingdetails(long booking_id);

	
}
