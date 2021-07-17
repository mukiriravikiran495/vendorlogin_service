package com.shifting_customers.dao;




import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_customers.model.Booking_details;



@Repository("user_booking_dao")
@Transactional
public class User_booking_daoImpl implements User_booking_dao{

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Booking_details> getbookings(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User_booking where user_id = :user_id");
		query.setParameter("user_id", id);
		List<Booking_details> list = query.list();
		return list;
	}

	@Override
	public Booking_details getbookingdetails(long booking_id) {
		Session session = sessionFactory.getCurrentSession();
		Booking_details details = session.get(Booking_details.class, booking_id);
		
		return details;
		
	}
	
	

	
	
	
}
