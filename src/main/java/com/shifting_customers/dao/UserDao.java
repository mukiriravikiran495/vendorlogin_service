package com.shifting_customers.dao;

import java.util.List;


import com.shifting_customers.model.User;


public interface UserDao {
	public String addUser(User user);
	public List<User> getUser();
	public User findById(int id);
	public User update(User user, int id);
	public User updateCountry(User user, int id);
	public void delete(int id);
	public String getOTP(User user);
	public String verifyotp(User user);
	public String resendOTP(User user);
	public String findByEmail(User user);
	public String resetpassword(User user);
	
}
