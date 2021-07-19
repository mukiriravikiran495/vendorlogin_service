package com.shifting_customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_customers.dao.Reviews_dao;
import com.shifting_customers.model.Reviews;

@Service("reviews_service")
public class Reviews_serviceImpl implements Reviews_service{

	@Autowired
	Reviews_dao dao;
	
	@Override
	public List<Reviews> getallreviews(long user_id) {
		return dao.getallreviews(user_id);
	}

}
