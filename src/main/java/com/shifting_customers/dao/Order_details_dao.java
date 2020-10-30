package com.shifting_customers.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shifting_customers.model.Order_details;

public interface Order_details_dao {

	List<Order_details> getOrderDetails();

	String createOrder(Order_details order_details);

	void delete(int id);

	Order_details findById(int id);

	Order_details getOrderByOrderId(int id);

	ResponseEntity<Order_details> cancelOrder(Order_details order_details);

}
