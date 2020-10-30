package com.shifting_customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shifting_customers.dao.Order_details_dao;
import com.shifting_customers.model.Order_details;

@Service("order_details_service")
public class Order_details_serviceImpl implements Order_details_service{

	@Autowired
	Order_details_dao orderDao; 
	
	@Override
	public List<Order_details> getOrderDetails() {
		return orderDao.getOrderDetails();
	}

	@Override
	public String createOrder(Order_details order_details) {
		return orderDao.createOrder(order_details);
	}
	
	public void deleteOrderById(int id) {
		// TODO Auto-generated method stub
		orderDao.delete(id);
	}
	
	public Order_details findById(int id) {
		// TODO Auto-generated method stub
		return orderDao.findById(id);
	}

	@Override
	public Order_details getOrderByOrderId(int id) {
		return orderDao.getOrderByOrderId(id);
	}

	@Override
	public ResponseEntity<Order_details> cancelOrder(Order_details order_details) {
		return orderDao.cancelOrder(order_details);
	}


}
