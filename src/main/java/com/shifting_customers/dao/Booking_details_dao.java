package com.shifting_customers.dao;

import java.util.List;

import com.shifting_customers.model.Booking_details;
import com.shifting_customers.model.Estimated_onebhk_items;
import com.shifting_customers.model.Estimated_threebhk_items;
import com.shifting_customers.model.Estimated_twobhk_items;
import com.shifting_customers.model.Estimated_villa_items;
import com.shifting_customers.model.House_items;
import com.shifting_customers.model.Merchant_price_details;
import com.shifting_customers.model.Merchant_profile;

public interface Booking_details_dao {

	List<Booking_details> getBookingDetails();

	String createBooking(Booking_details booking_details);

	void delete(long id);

	Booking_details findById(long id);

	Booking_details getBookingByBookingId(long id);

	
	List<Merchant_profile> getmerchantprofiles(String city);

	List<Merchant_price_details> getshift();

	String confirmbooking(Booking_details booking_details);

	String cancelbooking(Booking_details booking_details);

	List<Estimated_onebhk_items> getonebhkitems();

	List<Estimated_twobhk_items> gettwobhkitems();

	List<Estimated_threebhk_items> getthreebhkitems();

	String addonebhkitems(Estimated_onebhk_items items);

	String addtwobhkitems(Estimated_twobhk_items items);

	String addthreebhkitems(Estimated_threebhk_items items);

	String addvillaitems(Estimated_villa_items items);

	String addhouseitems(House_items items);

	List<Estimated_villa_items> getvillaitems();

	List<House_items> gethouseitems();

	
	
}
