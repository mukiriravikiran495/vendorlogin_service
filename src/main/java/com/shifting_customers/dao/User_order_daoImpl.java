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

import com.shifting_customers.model.Delivery_details;
import com.shifting_customers.model.From_house_details;
import com.shifting_customers.model.Order_details;
import com.shifting_customers.model.Merchant_order;
import com.shifting_customers.model.Merchant_profile;
import com.shifting_customers.model.Selected_items;
import com.shifting_customers.model.To_house_details;
import com.shifting_customers.model.User_order;
import com.shifting_customers.model.User_profile;

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
	
	@SuppressWarnings("rawtypes")
	private User_order findById(int user_id) {
		//System.out.println(user_id);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User_order where user_id = :user_id");
		query.setParameter("user_id", user_id);
		User_order user_order = (User_order) query.list().get(0);
		return user_order;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
	public String placeorder(User_order val) {
		
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Hello..");
		User_order user = findById(val.getUser_id());
		//System.out.println(user.toString());
		if(user == null) {
			return "Please Login .. !!";
		}
		else {
			System.out.println("else condition");
			System.out.println("Hey ..");
			
			
			System.out.println("Hooooo.....");
			Set<Order_details> order = new HashSet<Order_details>(val.getOrder_details());
			
			Order_details o = null;
			Iterator itr = null;
			itr = order.iterator();
			while(itr.hasNext()) {
				 o = (Order_details) itr.next();
				System.out.println(o.toString());
			}
			
			Order_details new_details = new Order_details();
			new_details.setFrom_location(o.getFrom_location());
			new_details.setTo_location(o.getTo_location());
			new_details.setShift_type(o.getShift_type());
			new_details.setStatus(o.getStatus());
			new_details.setUser_houseorder(user);
			int merchant_id = o.getMerchant_profile().getMerchant_id();
			System.out.println("Merchant_id :" +merchant_id);
			Merchant_order merchant_order = findMerchantId(merchant_id);
			new_details.setMerchant_order(merchant_order);
			
			session.save(new_details);
			System.out.println("1");
			From_house_details from_house_details = new From_house_details();
			from_house_details.setAppointment_date(o.getFrom_house_details().getAppointment_date());
			from_house_details.setFloor(o.getFrom_house_details().getFloor());
			from_house_details.setFrom_house_id(o.getFrom_house_details().getFrom_house_id());
			from_house_details.setPickup_contact(o.getFrom_house_details().getPickup_contact());
			from_house_details.setPickup_date(o.getFrom_house_details().getPickup_date());
			from_house_details.setPickupname(o.getFrom_house_details().getPickupname());
			from_house_details.setService_elevator(o.getFrom_house_details().getService_elevator());
			from_house_details.setHouse_type(o.getFrom_house_details().getHouse_type());
			from_house_details.setOrder_details(new_details);
			session.save(from_house_details);
			System.out.println("1");
			To_house_details to_house_details = new To_house_details();
			to_house_details.setDrop_contact(o.getTo_house_details().getDrop_contact());
			to_house_details.setDrop_date(o.getTo_house_details().getDrop_date());
			to_house_details.setDropname(o.getTo_house_details().getDropname());
			to_house_details.setFloor(o.getTo_house_details().getFloor());
			to_house_details.setService_elevator(o.getTo_house_details().getService_elevator());
			to_house_details.setTo_house_id(o.getTo_house_details().getTo_house_id());
			to_house_details.setOrder_details(new_details);
			
			session.save(to_house_details);
			System.out.println("1");
			User_profile profile = new User_profile();
			profile.setEmail(o.getUser_profile().getEmail());
			profile.setMobilenumber(o.getUser_profile().getMobilenumber());
			profile.setName(o.getUser_profile().getName());
			profile.setUser_id(val.getUser_id());
			profile.setOrder_details(new_details);
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
				s.setOrder_details(new_details);
				session.save(s);
			}
			Delivery_details delivery = new Delivery_details();
			delivery.setDelivery_date(o.getDelivery_details().getDelivery_date());
			delivery.setDelivery_id(o.getDelivery_details().getDelivery_id());
			delivery.setPrice(o.getDelivery_details().getPrice());
			delivery.setOrder_details(new_details);
			session.save(delivery);
			System.out.println("1");
			Merchant_profile merchant_profile = new Merchant_profile();
			
			merchant_profile.setMerchant_email(o.getMerchant_profile().getMerchant_email());
			merchant_profile.setMerchant_id(merchant_id);
			merchant_profile.setMerchant_name(o.getMerchant_profile().getMerchant_name());
			merchant_profile.setMobilenumber(o.getMerchant_profile().getMobilenumber());
			merchant_profile.setOrder_details(new_details);
			session.save(merchant_profile);
			System.out.println("1");
			
			
			return "Inserted ..!!";
		}

	}

	

	
	@SuppressWarnings("rawtypes")
	private Merchant_order findMerchantId(int merchant_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Merchant_order where merchant_id = :merchant_id");
		query.setParameter("merchant_id", merchant_id);
		Merchant_order merchant_order = (Merchant_order) query.list().get(0);
		return merchant_order;
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
