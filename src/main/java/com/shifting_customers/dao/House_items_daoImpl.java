package com.shifting_customers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_customers.model.House_items;

@Repository("house_items_dao")
@Transactional
public class House_items_daoImpl implements House_items_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<House_items> getItems() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from House_items");
		List<House_items> list = query.list();
		return list;
	}

}
