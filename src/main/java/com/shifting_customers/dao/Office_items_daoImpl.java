package com.shifting_customers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_customers.model.Office_items;

@Repository("office_items_dao")
@Transactional
public class Office_items_daoImpl implements Office_items_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Office_items> getItems() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Office_items");
		List<Office_items> list = query.list();
		return list;
	}

}
