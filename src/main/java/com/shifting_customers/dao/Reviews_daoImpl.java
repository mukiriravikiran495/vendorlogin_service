package com.shifting_customers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_customers.model.Reviews;

@Repository("reviews_dao")
@Transactional
public class Reviews_daoImpl implements Reviews_dao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Reviews> getallreviews(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User_reviews where user_id = :user_id");
		query.setParameter("user_id", id);
		List<Reviews> list = query.list();
		return list;
	}

}
