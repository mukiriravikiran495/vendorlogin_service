package com.shifting_customers.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_customers.model.Booking_details;
import com.shifting_customers.model.Booking_status;
import com.shifting_customers.model.Estimated_onebhk_items;
import com.shifting_customers.model.Estimated_threebhk_items;
import com.shifting_customers.model.Estimated_twobhk_items;
import com.shifting_customers.model.Estimated_villa_items;
import com.shifting_customers.model.Final_price_details;
import com.shifting_customers.model.House_categories;
import com.shifting_customers.model.House_items;
import com.shifting_customers.model.Merchant_booking;
import com.shifting_customers.model.Merchant_details;
import com.shifting_customers.model.Merchant_price_details;
import com.shifting_customers.model.Merchant_profile;
import com.shifting_customers.model.Office_categories;
import com.shifting_customers.model.Payment_mode;
import com.shifting_customers.model.Payment_status;
import com.shifting_customers.model.Selected_items;
import com.shifting_customers.model.User_booking;
import com.shifting_customers.model.User_profile;
import com.shifting_customers.model.Vehicle_categories;
import com.shifting_customers.model.Vehicle_details;

@Repository("booking_details_dao")
@Transactional
public class Booking_details_daoImpl implements Booking_details_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getBookingDetails() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details");
		List<Booking_details> list = query.list();
		return list;
	}

	@Override
	public String createBooking(Booking_details booking_details) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Booking_details findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where  booking_id=:booking_id");
		query.setParameter("booking_id", id);
		return (Booking_details) query.list().get(0);
	}
	
	public void delete(long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Booking_details booking_details = findById(id);
		session.delete(booking_details);
	}

	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Merchant_price_details> getshift() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_price_details  where shift_type = :shift_type ");
		query.setParameter("shift_type", "one bhk");
		List<Merchant_price_details> list = query.list();
		return list;
	}

	
	@Override
	public String cancelbooking(Booking_details val, long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Booking_details details = session.get(Booking_details.class, booking_id);
		
		details.setBooking_status(Booking_status.BookingCancelled);
		System.out.println("Hello..");
		session.update(details);
		return "Cancelled ...!!";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Booking_details getBookingByBookingId(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where  booking_id=:booking_id");
		query.setParameter("booking_id", id);
		Booking_details details =  (Booking_details) query.list().get(0);
		return details;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Estimated_onebhk_items> getonebhkitems() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Estimated_onebhk_items");
		List<Estimated_onebhk_items> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Estimated_twobhk_items> gettwobhkitems() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Estimated_twobhk_items");
		List<Estimated_twobhk_items> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Estimated_threebhk_items> getthreebhkitems() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Estimated_threebhk_items");
		List<Estimated_threebhk_items> list = query.list();
		return list;
	}

	@Override
	public String addonebhkitems(Estimated_onebhk_items items) {
		Session session = sessionFactory.getCurrentSession();
		session.save(items);
		return " Inserted ..!!";
	}

	@Override
	public String addtwobhkitems(Estimated_twobhk_items items) {
		Session session = sessionFactory.getCurrentSession();
		session.save(items);
		return " Inserted ..!!";
	}

	@Override
	public String addthreebhkitems(Estimated_threebhk_items items) {
		Session session = sessionFactory.getCurrentSession();
		session.save(items);
		return " Inserted ..!!";
	}

	@Override
	public String addvillaitems(Estimated_villa_items items) {
		Session session = sessionFactory.getCurrentSession();
		session.save(items);
		return " Inserted ..!!";
	}

	@Override
	public String addhouseitems(House_items items) {
		Session session = sessionFactory.getCurrentSession();
		session.save(items);
		return " Inserted ..!!";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Estimated_villa_items> getvillaitems() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Estimated_villa_items");
		List<Estimated_villa_items> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<House_items> gethouseitems() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from House_items");
		List<House_items> list = query.list();
		return list;
	}

	@Override
	public String getmerchant(Booking_details booking_details ) {
		Session session = sessionFactory.getCurrentSession();
		Merchant_booking details = session.get(Merchant_booking.class, booking_details.getMerchant_details().getMerchant_id());
		System.out.println(details.getMerchant_id());
		return "done";
	}

	@Override
	public String addbookingdetails(Booking_details booking_details, long user_id  ) {
		Session session = sessionFactory.getCurrentSession();
		User_booking user_booking = session.get(User_booking.class, user_id);
		Booking_details details = new Booking_details();
		details.setBooking_id(booking_details.getBooking_id());
		details.setFrom_location(booking_details.getFrom_location());
		details.setTo_location(booking_details.getTo_location());
		details.setPickup_date(booking_details.getPickup_date());
		details.setShift_type(booking_details.getShift_type());
		details.setBooking_status(Booking_status.BookingPending);
		details.setPayment_status(Payment_status.Unpaid);
		details.setPayment_mode(Payment_mode.Unpaid);
		details.setUser_booking(user_booking);
		
		session.save(details);
		
		User_profile user_profile = new User_profile();
		//user_profile.setUser_profile_id(booking_details.getUser_profile().getUser_profile_id());
		user_profile.setUser_id(booking_details.getUser_profile().getUser_id());
		user_profile.setName(booking_details.getUser_profile().getName());
		user_profile.setEmail(booking_details.getUser_profile().getEmail());
		user_profile.setMobilenumber(booking_details.getUser_profile().getMobilenumber());
		user_profile.setBooking_details(details);
		session.save(user_profile);
		
		return " Inserted .. !!";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String addselecteditems(List<Selected_items> selected_items, long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Booking_details details = session.get(Booking_details.class, booking_id);
		Set<Selected_items> items = new HashSet<Selected_items>(selected_items);
		Iterator itr = items.iterator();
		Selected_items item = null;
		while(itr.hasNext()) {
			item = (Selected_items) itr.next();
			Selected_items s = new Selected_items();
			s.setItem(item.getItem());
			s.setItem_type(item.getItem_type());
			s.setQuantity(item.getQuantity());
			s.setSelected_items_id(item.getSelected_items_id());
			s.setBooking_details(details);
			session.save(s);
		}
		System.out.println("Selected_items done ..");
		
		return "Inserted ..!!";
		
		
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Merchant_profile> getmerchantprofiles(String location) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_profile where city = :city ");
		query.setParameter("city", location);
		
		List<Merchant_profile> list = query.list();
		return list;
	}

	@Override
	public String completebooking(Final_price_details final_price_details, long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Booking_details details = session.get(Booking_details.class, booking_id);
		User_profile profile = details.getUser_profile();
		if(profile.getName() == null && profile.getEmail() == null) {
			System.out.println("Please enter name and email");
		}else {
			details.setBooking_status(Booking_status.BookingCompleted);
			
			
			
			Final_price_details price = new Final_price_details();
			price.setAcinstallanduninstall(final_price_details.getAcinstallanduninstall());
			price.setBooking_details(details);
			price.setGrand_total(final_price_details.getGrand_total());
			price.setLabour_charges(final_price_details.getLabour_charges());
			price.setOffer(final_price_details.getOffer());
			price.setTax(final_price_details.getTax());
			price.setTollgate_charges(final_price_details.getTollgate_charges());
			price.setTotal_amount(final_price_details.getTotal_amount());
			price.setWrapping_charges(final_price_details.getWrapping_charges());
			session.save(price);
			System.out.println("Inserted ..!!");
		}
		return " ";
		
	}

	@Override
	public String addmerchantdetails(Merchant_details merchant_details, long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Merchant_details m = new Merchant_details();
		m.setMerchant_id(merchant_details.getMerchant_id());
		m.setMerchant_email(merchant_details.getMerchant_email());
		m.setMerchant_name(merchant_details.getMerchant_name());
		m.setMobilenumber(merchant_details.getMobilenumber());
		Booking_details booking_details = session.get(Booking_details.class, booking_id);
		m.setBooking_details(booking_details);
		
		session.save(m);
		return "inserted.. !!";
	}

	@Override
	public String addmerchant_details(Booking_details booking_details, long merchant_id, long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		Merchant_booking merchant_booking = session.get(Merchant_booking.class, merchant_id);
		
		Booking_details details = session.get(Booking_details.class, booking_id);
		details.setMerchant_booking(merchant_booking);
		
		session.save(booking_details);
		
		return "Inserted ..!!";
	}

	@Override
	public String updateuserprofile(User_profile user_profile, long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details booking_details = session.get(Booking_details.class, booking_id);
		
		User_profile profile = booking_details.getUser_profile();
		profile.setEmail(user_profile.getEmail());
		profile.setName(user_profile.getName());
		session.update(booking_details);
		
		return "Updated ..!!";
	}

	@Override
	public Booking_details getbookingdetails(long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details details = session.get(Booking_details.class, booking_id);
		return details;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<House_categories> gethousecategories() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from House_categories");
		List<House_categories> list = query.list();
		return list;
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Office_categories> getofficecategories() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Office_categories");
		List<Office_categories> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Vehicle_categories> getvehiclecategories() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Vehicle_categories");
		List<Vehicle_categories> list = query.list();
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String addvehicle_details(List<Vehicle_details> vehicle_details, long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details details = session.get(Booking_details.class, booking_id);
		Set<Vehicle_details> items = new HashSet<Vehicle_details>(vehicle_details);
		Iterator itr = items.iterator();
		Vehicle_details item = null;
		while(itr.hasNext()) {
			item = (Vehicle_details) itr.next();
			Vehicle_details s = new Vehicle_details();
			s.setVehicle_details_id(item.getVehicle_details_id());
			s.setVehicle_type(item.getVehicle_type());
			s.setNameOnRC(item.getNameOnRC());
			s.setRegistration_date(item.getRegistration_date());
			s.setVehicle_company(item.getVehicle_company());
			s.setVehicle_model(item.getVehicle_model());
			s.setBooking_details(details);
			session.save(s);
		}
		System.out.println("Vehicle details added ..!!");
		return "Inserted ..!!";
	}

	

	

	
	

	

	

	
}
