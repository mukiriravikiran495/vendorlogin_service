package com.shifting_customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shifting_customers.dao.User_profile_dao;
import com.shifting_customers.model.User_profile;

@RestController
@RequestMapping( path = "/user_profile")
public class User_profile_controller {
	
	@Autowired
	User_profile_dao dao;
	
	@GetMapping( value = "/getprofiles")
	public List<User_profile> getprofiles(){
		List<User_profile> list = dao.getprofiles();
		return list;
	}

}
