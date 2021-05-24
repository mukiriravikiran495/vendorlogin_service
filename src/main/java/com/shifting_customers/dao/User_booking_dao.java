package com.shifting_customers.dao;

import java.util.List;

import com.shifting_customers.model.User_booking;

public interface User_booking_dao {

	List<User_booking> getbookings();

	String placeorder(User_booking user_booking);

	List<User_booking> getallBookingsbyUser_id(int id);

	
}
