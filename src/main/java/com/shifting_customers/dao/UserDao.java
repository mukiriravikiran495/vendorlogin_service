package com.shifting_customers.dao;

import java.util.List;

import com.shifting_customers.model.Reviews;
import com.shifting_customers.model.User;


public interface UserDao {
	public String addUser(User user);
	public List<User> getUsers();
	public User findById(long id);
	public User update(User user, long id);
	public User updateCountry(User user, long id);
	public void delete(long id);
	public String getOTP(long mobilenumber);
	public String verifyotp(User user);
	public String resendOTP(User user);
	public String findByEmail(User user);
	public String resetpassword(User user);
	public String addreview(Reviews reviews, long user_id, long merchant_id);
	
}
