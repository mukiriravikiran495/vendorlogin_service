package com.shifting_customers.service;

import java.util.List;


import com.shifting_customers.model.User;


public interface UserService {
	public String createUser(User user);
	public List<User> getUsers();
	public User findById(long l);
	public User update(User user, long id);
	public void deleteUserById(long id);
	public User updatePartially(User user, long id);
	public String getOTP(User user);
	public String verifyotp(User user);
	public String resendOTP(User user);
	public String findByEmail(User user);
	public String resetpassword(User user);
	
}
