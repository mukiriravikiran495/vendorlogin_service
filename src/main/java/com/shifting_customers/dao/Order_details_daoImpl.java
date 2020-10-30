package com.shifting_customers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_customers.model.Order_details;
import com.shifting_customers.model.Status;

@Repository("order_details_dao")
@Transactional
public class Order_details_daoImpl implements Order_details_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Order_details> getOrderDetails() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order_details");
		List<Order_details> list = query.list();
		return list;
	}

	@Override
	public String createOrder(Order_details order_details) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Order_details findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order_details where  order_id=:order_id");
		query.setParameter("order_id", id);
		return (Order_details) query.list().get(0);
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Order_details order_details = findById(id);
		session.delete(order_details);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Order_details getOrderByOrderId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order_details where  order_id=:order_id");
		query.setParameter("order_id", id);
		return (Order_details) query.list().get(0);
	}

	@Override
	public ResponseEntity<Order_details> cancelOrder(Order_details val) {
		Session session = sessionFactory.getCurrentSession();
		Order_details order_details = findById(val.getOrder_id());
		order_details.setStatus(Status.Cancelled);
		session.update(order_details);
		return new ResponseEntity<Order_details>(order_details,HttpStatus.OK);
	}
}
