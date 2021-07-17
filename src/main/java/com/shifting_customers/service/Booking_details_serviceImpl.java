package com.shifting_customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_customers.dao.Booking_details_dao;
import com.shifting_customers.model.Booking_details;
import com.shifting_customers.model.Estimated_onebhk_items;
import com.shifting_customers.model.Estimated_threebhk_items;
import com.shifting_customers.model.Estimated_twobhk_items;
import com.shifting_customers.model.Estimated_villa_items;
import com.shifting_customers.model.House_items;
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
	public List<Merchant_profile> getmerchantprofiles(String city) {
		return dao.getmerchantprofiles(city);
	}

	@Override
	public List<Merchant_price_details> getshift() {
		return dao.getshift();
	}

	@Override
	public String confirmbooking(Booking_details booking_details) {
		return dao.confirmbooking(booking_details);
	}

	@Override
	public String cancelbooking(Booking_details booking_details) {
		return dao.cancelbooking(booking_details);
	}

	@Override
	public List<Estimated_onebhk_items> getonebhkitems() {
		return dao.getonebhkitems();
	}

	@Override
	public List<Estimated_twobhk_items> gettwobhkitems() {
		return dao.gettwobhkitems();
	}

	@Override
	public List<Estimated_threebhk_items> getthreebhkitems() {
		return dao.getthreebhkitems();
	}

	@Override
	public String addonebhkitems(Estimated_onebhk_items items ) {
		return dao.addonebhkitems(items);
	}

	@Override
	public String addtwobhkitems(Estimated_twobhk_items items) {
		return dao.addtwobhkitems(items);
	}

	@Override
	public String addthreebhkitems(Estimated_threebhk_items items) {
		return dao.addthreebhkitems(items);
	}

	@Override
	public String addvillaitems(Estimated_villa_items items) {
		return dao.addvillaitems(items);
	}

	@Override
	public String addhouseitems(House_items items) {
		return dao.addhouseitems(items);
	}

	@Override
	public List<Estimated_villa_items> getvillaitems() {
		return dao.getvillaitems();
	}

	@Override
	public List<House_items> gethouseitems() {
		return dao.gethouseitems();
	}

	
	
	
	
}
