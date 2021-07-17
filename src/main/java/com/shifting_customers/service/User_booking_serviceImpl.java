package com.shifting_customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_customers.dao.User_booking_dao;
import com.shifting_customers.model.Booking_details;

@Service("user_booking_service")
public class User_booking_serviceImpl implements User_booking_service{

	@Autowired
	User_booking_dao dao;

	
	@Override
	public List<Booking_details> getBookings(long user_id) {
		return dao.getbookings(user_id);
	}


	@Override
	public Booking_details getbookingdetails(long booking_id) {
		return dao.getbookingdetails(booking_id);
	}
	
	

}
