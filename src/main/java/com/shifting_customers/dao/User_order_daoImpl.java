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

import com.shifting_customers.model.From_house_details;
import com.shifting_customers.model.Merchant_profile;
import com.shifting_customers.model.Order_details;
import com.shifting_customers.model.To_house_details;
import com.shifting_customers.model.User_order;

@Repository("user_order_dao")
@Transactional
public class User_order_daoImpl implements User_order_dao{

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<User_order> getorders() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User_order");
		List<User_order> list = query.list();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "null" })
	@Override
	public String placeorder(User_order val) {
		
		Session session = sessionFactory.getCurrentSession();
		User_order user_order = new User_order();
		user_order.setUser_id(val.getUser_id());
		
		session.save(user_order);
		Order_details o = null;
		Iterator itr = null;
		
		
		Set<Order_details> order = new HashSet<Order_details>(val.getOrder_details());
		
		itr = order.iterator();
		while(itr.hasNext()) {
			 o = (Order_details) itr.next();
			System.out.println(o.toString());
		}
		
		Order_details new_details = new Order_details();
		new_details.setFrom_location(o.getFrom_location());
		new_details.setTo_location(o.getTo_location());
		new_details.setHouse_type(o.getHouse_type());
		new_details.setStatus(o.getStatus());
		new_details.setUser_order(user_order);
		
		session.save(new_details);
		
		From_house_details from_house_details = new From_house_details();
		from_house_details.setAppointment_date(o.getFrom_house_details().getAppointment_date());
		from_house_details.setFloor(o.getFrom_house_details().getFloor());
		from_house_details.setFrom_house_id(o.getFrom_house_details().getFrom_house_id());
		from_house_details.setPickup_contact(o.getFrom_house_details().getPickup_contact());
		from_house_details.setPickup_date(o.getFrom_house_details().getPickup_date());
		from_house_details.setPickupname(o.getFrom_house_details().getPickupname());
		from_house_details.setService_elevator(o.getFrom_house_details().getService_elevator());
		from_house_details.setOrder_details(new_details);
		session.save(from_house_details);
		
		To_house_details to_house_details = new To_house_details();
		to_house_details.setDrop_contact(o.getTo_house_details().getDrop_contact());
		to_house_details.setDrop_date(o.getTo_house_details().getDrop_date());
		to_house_details.setDropname(o.getTo_house_details().getDropname());
		to_house_details.setFloor(o.getTo_house_details().getFloor());
		to_house_details.setService_elevator(o.getTo_house_details().getService_elevator());
		to_house_details.setTo_house_id(o.getTo_house_details().getTo_house_id());
		to_house_details.setOrder_details(new_details);
		
		session.save(to_house_details);
		
		Merchant_profile  profile = new Merchant_profile();
		
		
		return "Inserted ..!!";
	
}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<User_order> getallOrdersbyUser_id(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User_order where user_id = :id");
		query.setParameter("id", id);
		List<User_order> list = query.list();
		return list;
	}
	
	
}
