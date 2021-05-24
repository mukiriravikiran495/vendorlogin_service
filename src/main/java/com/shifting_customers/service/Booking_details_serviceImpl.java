package com.shifting_customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shifting_customers.dao.Booking_details_dao;
import com.shifting_customers.model.Booking_details;
import com.shifting_customers.model.Final_price_details;
import com.shifting_customers.model.Merchant_price_details;
import com.shifting_customers.model.Merchant_profile;


@Service("booking_details_service")
public class Booking_details_serviceImpl implements Booking_details_service{

	@Autowired
	Booking_details_dao dao; 
	
	@Override
	public List<Booking_details> getBookingDetails() {
		return dao.getBookingDetails();
	}

	@Override
	public String createBooking(Booking_details booking_details) {
		return dao.createBooking(booking_details);
	}
	
	public void deleteBookingById(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}
	
	public Booking_details findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Booking_details getBookingByBookingId(int id) {
		return dao.getBookingByBookingId(id);
	}

	@Override
	public ResponseEntity<Booking_details> cancelBooking(Booking_details booking_details) {
		return dao.cancelBooking(booking_details);
	}

	@Override
	public List<Merchant_profile> getmerchantprofiles(String city) {
		return dao.getmerchantprofiles(city);
	}

	@Override
	public List<Merchant_price_details> getshift() {
		return dao.getshift();
	}

	@Override
	public String addbooking_details(Booking_details booking_details) {
		return dao.addbooking_details(booking_details);
	}

	@Override
	public String addpricedetails(Final_price_details final_price_details, long booking_id) {
		return dao.addpricedetails(final_price_details, booking_id);
	}

}
