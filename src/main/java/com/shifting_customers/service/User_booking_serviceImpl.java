package com.shifting_customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_customers.dao.User_booking_dao;

import com.shifting_customers.model.User_booking;

@Service("user_booking_service")
public class User_booking_serviceImpl implements User_booking_service{

	@Autowired
	User_booking_dao dao;

	@Override
	public List<User_booking> getbookings() {
		return dao.getbookings();
	}

	@Override
	public String placeorder(User_booking user_booking) {
		return dao.placeorder(user_booking);
	}

	@Override
	public List<User_booking> getallBookingsbyUser_id(int id) {
		return dao.getallBookingsbyUser_id(id);
	}
	
	

}
