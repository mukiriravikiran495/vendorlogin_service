package com.shifting_customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shifting_customers.dao.User_order_dao;
import com.shifting_customers.model.User_order;

@Service("user_order_service")
public class User_order_serviceImpl implements User_order_service{

	@Autowired
	User_order_dao dao;

	@Override
	public List<User_order> getorders() {
		return dao.getorders();
	}

	@Override
	public String placeorder(User_order user_order) {
		return dao.placeorder(user_order);
	}

	@Override
	public List<User_order> getallOrdersbyUser_id(int id) {
		return dao.getallOrdersbyUser_id(id);
	}
	
	

}
