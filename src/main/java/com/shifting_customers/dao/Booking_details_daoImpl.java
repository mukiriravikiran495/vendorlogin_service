package com.shifting_customers.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.shifting_customers.model.Booking_details;
import com.shifting_customers.model.Final_price_details;
import com.shifting_customers.model.Merchant_booking;
import com.shifting_customers.model.Merchant_details;
import com.shifting_customers.model.Merchant_price_details;
import com.shifting_customers.model.Merchant_profile;
import com.shifting_customers.model.Selected_items;
import com.shifting_customers.model.Status;
import com.shifting_customers.model.User_booking;
import com.shifting_customers.model.User_profile;

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

	@SuppressWarnings("rawtypes")
	@Override
	public Booking_details getBookingByBookingId(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Booking_details where  booking_id=:booking_id");
		query.setParameter("booking_id", id);
		return (Booking_details) query.list().get(0);
	}

	@Override
	public ResponseEntity<Booking_details> cancelBooking(Booking_details val) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details booking_details = findById(val.getBooking_id());
		booking_details.setStatus(Status.Cancelled);
		session.update(booking_details);
		return new ResponseEntity<Booking_details>(booking_details,HttpStatus.OK);
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Merchant_price_details> getshift() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_price_details  where shift_type = :shift_type ");
		query.setParameter("shift_type", "one bhk");
		List<Merchant_price_details> list = query.list();
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String addbooking_details(Booking_details booking_details) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details details = new Booking_details();
		details.setBooking_id(booking_details.getBooking_id());
		details.setDrop_date(booking_details.getDrop_date());
		details.setFrom_floor(booking_details.getFrom_floor());
		details.setFrom_lift(booking_details.getFrom_lift());
		details.setFrom_location(booking_details.getFrom_location());
		details.setPickup_date(booking_details.getPickup_date());
		details.setShift_type(booking_details.getShift_type());
		details.setTo_floor(booking_details.getTo_floor());
		details.setTo_lift(booking_details.getTo_lift());
		details.setTo_location(booking_details.getTo_location());
		details.setStatus(booking_details.getStatus());
		//get user_booking
		User_booking user_booking = session.get(User_booking.class, booking_details.getUser_profile().getUser_id());
		System.out.println("User_booking : "+user_booking);
		details.setUser_booking(user_booking);
		//get Merchant_booking
		Merchant_booking merchant_booking = session.get(Merchant_booking.class, booking_details.getMerchant_details().getMerchant_id());
		details.setMerchant_booking(merchant_booking);
		System.out.println("Merchant_booking : "+merchant_booking);
		session.save(details);
		System.out.println("booking_details done ..");
		
		User_profile user_profile = new User_profile();
		//User_profile user = session.get(User_profile.class, booking_details.getUser_profile().getUser_id());
		
		user_profile.setUser_profile_id(booking_details.getUser_profile().getUser_profile_id());
		user_profile.setUser_id(booking_details.getUser_profile().getUser_id());
		user_profile.setEmail(booking_details.getUser_profile().getEmail());
		user_profile.setMobilenumber(booking_details.getUser_profile().getMobilenumber());
		user_profile.setName(booking_details.getUser_profile().getName());
		user_profile.setBooking_details(details);
		System.out.println("user_profile  .."+user_profile.toString());
		session.save(user_profile);
		
		
		System.out.println("user_profile done ..");
		
		Merchant_details m = new Merchant_details();
		m.setMerchant_details_id(booking_details.getMerchant_details().getMerchant_details_id());
		m.setMerchant_email(booking_details.getMerchant_details().getMerchant_email());
		m.setMerchant_id(booking_details.getMerchant_details().getMerchant_id());
		m.setMerchant_name(booking_details.getMerchant_details().getMerchant_name());
		m.setMobilenumber(booking_details.getMerchant_details().getMobilenumber());
		m.setBooking_details(details);
		System.out.println("Merchant_details  .."+m.toString());
		session.save(m);
		
		System.out.println("Merchant_details done ..");
		
		Set<Selected_items> items = new HashSet<Selected_items>(booking_details.getSelected_items());
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
		
		Final_price_details price = new Final_price_details();
		long amount = booking_details.getFinal_price_details().getAmount();
		System.out.println("amount .."+amount);
		price.setAmount(amount);
		System.out.println("1 ..");
		price.setFinal_amount(booking_details.getFinal_price_details().getFinal_amount());
		System.out.println("2 ..");
		price.setFrinal_price_details_id(booking_details.getFinal_price_details().getFrinal_price_details_id());
		System.out.println("3 ..");
		price.setInstallanduninstall(booking_details.getFinal_price_details().getInstallanduninstall());
		System.out.println("4 ..");
		price.setLabour_charges(booking_details.getFinal_price_details().getLabour_charges());
		System.out.println("5 ..");
		price.setOffer(booking_details.getFinal_price_details().getOffer());
		System.out.println("6 ..");
		price.setTax(booking_details.getFinal_price_details().getTax());
		System.out.println("7 ..");
		price.setBooking_details(details);
		System.out.println("8 ..");
		System.out.println("Final_price_details  .."+price.toString());
		session.save(price);
		System.out.println("9 ..");
		
		
		
		return "Inserted ..!!";
	}

	@Override
	public String addpricedetails(Final_price_details final_price_details, long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Final_price_details details = new Final_price_details();
		details.setAmount(final_price_details.getAmount());
		details.setFinal_amount(final_price_details.getFinal_amount());
		details.setFrinal_price_details_id(final_price_details.getFrinal_price_details_id());
		details.setInstallanduninstall(final_price_details.getInstallanduninstall());
		details.setLabour_charges(final_price_details.getLabour_charges());
		details.setOffer(final_price_details.getOffer());
		details.setTax(final_price_details.getTax());
		
		Booking_details booking = session.get(Booking_details.class, booking_id);
		details.setBooking_details(booking);
		session.save(details);
		
		return null;
	}

	

	

	

	
}
