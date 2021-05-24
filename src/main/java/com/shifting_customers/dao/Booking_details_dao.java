package com.shifting_customers.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shifting_customers.model.Booking_details;
import com.shifting_customers.model.Final_price_details;
import com.shifting_customers.model.Merchant_price_details;
import com.shifting_customers.model.Merchant_profile;

public interface Booking_details_dao {

	List<Booking_details> getBookingDetails();

	String createBooking(Booking_details booking_details);

	void delete(long id);

	Booking_details findById(long id);

	Booking_details getBookingByBookingId(long id);

	ResponseEntity<Booking_details> cancelBooking(Booking_details booking_details);

	List<Merchant_profile> getmerchantprofiles(String city);

	List<Merchant_price_details> getshift();

	String addbooking_details(Booking_details booking_details);

	String addpricedetails(Final_price_details final_price_details, long booking_id);

}
