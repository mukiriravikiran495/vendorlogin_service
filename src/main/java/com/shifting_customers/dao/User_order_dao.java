package com.shifting_customers.dao;

import java.util.List;

import com.shifting_customers.model.User_order;

public interface User_order_dao {

	List<User_order> getorders();

	String placeorder(User_order user_order);

	List<User_order> getallOrdersbyUser_id(int id);

	
}
