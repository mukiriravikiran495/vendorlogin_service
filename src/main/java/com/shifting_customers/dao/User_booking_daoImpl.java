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
import com.shifting_customers.model.Final_price_details;
import com.shifting_customers.model.Merchant_booking;
import com.shifting_customers.model.Merchant_details;
import com.shifting_customers.model.Selected_items;
import com.shifting_customers.model.User_booking;
import com.shifting_customers.model.User_profile;

@Repository("user_booking_dao")
@Transactional
public class User_booking_daoImpl implements User_booking_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<User_booking> getbookings() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User_booking");
		List<User_booking> list = query.list();
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	private User_booking findById(long l) {
		//System.out.println(user_id);
		Session session = sessionFactory.getCurrentSession();
		System.out.println("user_id = "+l);
		Query query = session.createQuery("from User_booking where user_id = :user_id");
		query.setParameter("user_id", l);
		User_booking user_booking = (User_booking) query.list().get(0);
		return user_booking;
	}

	
	
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
	public String placeorder(User_booking val) {
		
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Hello..");
		User_booking user = findById(val.getUser_id());
		System.out.println(user.toString());
		if(user == null) {
			return "Please Login .. !!";
		}
		else {
			System.out.println("else condition");
			System.out.println("Hey ..");
			
			
			System.out.println("Hooooo.....");
			System.out.println("Hey .."+val.getBooking_details().toString());
			Set<Booking_details> order = new HashSet<Booking_details>(val.getBooking_details());
			
			Booking_details o = null;
			Iterator itr = null;
			itr = order.iterator();
			while(itr.hasNext()) {
				 o = (Booking_details) itr.next();
				System.out.println(" hello.."+o.toString());
			}
			
			Booking_details new_details = new Booking_details();
			new_details.setBooking_id(o.getBooking_id());
			new_details.setDrop_date(o.getDrop_date());
			new_details.setFrom_floor(o.getFrom_floor());
			new_details.setFrom_lift(o.getFrom_lift());
			new_details.setFrom_location(o.getFrom_location());
			new_details.setPickup_date(o.getPickup_date());
			new_details.setShift_type(o.getShift_type());
			new_details.setTo_floor(o.getTo_floor());
			new_details.setTo_lift(o.getTo_lift());
			new_details.setTo_location(o.getTo_location());
			new_details.setStatus(o.getStatus());
			new_details.setUser_booking(user);
			long merchant_id = o.getMerchant_details().getMerchant_id();
			System.out.println("Merchant_id :" +merchant_id);
			Merchant_booking merchant_booking = findMerchantId(merchant_id);
			new_details.setMerchant_booking(merchant_booking);
			
			session.save(new_details);
			
			
			System.out.println("1");
			
			User_profile profile = new User_profile();
			profile.setUser_profile_id(o.getUser_profile().getUser_profile_id());
			profile.setUser_id(o.getUser_profile().getUser_id());
			profile.setEmail(o.getUser_profile().getEmail());
			profile.setMobilenumber(o.getUser_profile().getMobilenumber());
			profile.setName(o.getUser_profile().getName());
			profile.setBooking_details(new_details);
			session.save(profile);
			System.out.println("1");
			Selected_items selected = null;
			Selected_items s = null;
			Set<Selected_items> items = new HashSet<Selected_items>(o.getSelected_items());
			Iterator itrerator = items.iterator();
			while(itrerator.hasNext()) {
				selected = (Selected_items) itrerator.next();
				 s = new Selected_items();
				s.setItem(selected.getItem());
				s.setItem_type(selected.getItem_type());
				s.setQuantity(selected.getQuantity());
				s.setSelected_items_id(selected.getSelected_items_id());
				s.setBooking_details(new_details);
				session.save(s);
			}
			
			System.out.println("1");
			Merchant_details m = new Merchant_details();
			
			m.setMerchant_details_id(o.getMerchant_details().getMerchant_details_id());
			m.setMerchant_email(o.getMerchant_details().getMerchant_email());
			m.setMerchant_id(o.getMerchant_details().getMerchant_id());
			m.setMerchant_name(o.getMerchant_details().getMerchant_name());
			m.setMobilenumber(o.getMerchant_details().getMobilenumber());
			
			m.setBooking_details(new_details);
			session.save(m);
			System.out.println("1");
			
			Final_price_details price = new Final_price_details();
			price.setAmount(o.getFinal_price_details().getAmount());
			
			price.setFinal_amount(o.getFinal_price_details().getFinal_amount());
			price.setFrinal_price_details_id(o.getFinal_price_details().getFrinal_price_details_id());
			price.setInstallanduninstall(o.getFinal_price_details().getInstallanduninstall());
			price.setLabour_charges(o.getFinal_price_details().getLabour_charges());
			price.setOffer(o.getFinal_price_details().getOffer());
			price.setTax(o.getFinal_price_details().getTax());
			price.setBooking_details(new_details);
			System.out.println("Final_price_details  .."+price.toString());
			session.save(price);
			System.out.println("Final_price_details done ..");
			
			
			return "Inserted ..!!";
		}

	}

	

	
	

	@SuppressWarnings("rawtypes")
	private Merchant_booking findMerchantId(long merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_booking where merchant_id = :merchant_id");
		query.setParameter("merchant_id", merchant_id);
		Merchant_booking merchant_booking = (Merchant_booking) query.list().get(0);
		return merchant_booking;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<User_booking> getallBookingsbyUser_id(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User_booking where user_id = :id");
		query.setParameter("id", id);
		List<User_booking> list = query.list();
		return list;
	}
	
	
}
