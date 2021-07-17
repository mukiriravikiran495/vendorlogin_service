package com.shifting_customers.service;

import java.util.List;

import com.shifting_customers.model.Booking_details;
import com.shifting_customers.model.Estimated_onebhk_items;
import com.shifting_customers.model.Estimated_threebhk_items;
import com.shifting_customers.model.Estimated_twobhk_items;
import com.shifting_customers.model.Estimated_villa_items;
import com.shifting_customers.model.Final_price_details;
import com.shifting_customers.model.House_items;
import com.shifting_customers.model.Merchant_details;
import com.shifting_customers.model.Merchant_price_details;
import com.shifting_customers.model.Merchant_profile;
import com.shifting_customers.model.Selected_items;
import com.shifting_customers.model.User_profile;


public interface Booking_details_service {

	List<Booking_details> getBookingDetails();

	String createBooking(Booking_details booking_details);

	void deleteBookingById(int id);

	Booking_details findById(int id);

	Booking_details getBookingByBookingId(int id);

	List<Merchant_profile> getmerchantprofiles(String city);

	List<Merchant_price_details> getshift();

	

	String cancelbooking(Booking_details booking_details, long booking_id);

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

	String addbookingdetails(Booking_details booking_details, long user_id );

	String addselecteditems(List<Selected_items> selected_items, long booking_id);

	String completebooking(Final_price_details final_price_details, long booking_id );

	String addmerchant_details(Merchant_details merchant_details, long booking_id);

	String addmerchant_booking(Booking_details booking_details, long booking_id, long merchant_id);

	String updateuserprofile(User_profile user_profile, long booking_id);

	Booking_details getbookingdetails(long booking_id);

	 
		
}
