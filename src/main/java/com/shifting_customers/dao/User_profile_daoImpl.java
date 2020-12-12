package com.shifting_customers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_customers.model.User_profile;

@Repository("user_profile_dao")
@Transactional
public class User_profile_daoImpl implements User_profile_dao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<User_profile> getprofiles() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User_profile");
		List<User_profile> list = query.list();
		return list;
	}
	
	
}
