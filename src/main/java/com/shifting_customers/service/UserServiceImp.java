package com.shifting_customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_customers.dao.UserDao;
import com.shifting_customers.model.User;

@Service("userService")
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserDao userDao;

	
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	public User findById(long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	public String createUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}
	@Override
	public User updatePartially(User user, long id) {
		userDao.updateCountry(user,id);
		return userDao.findById(id);
	}

	@Override
	public User update(User user,long id) {
		// TODO Auto-generated method stub
		return userDao.update(user, id);
	}

	@Override
	public String getOTP(long mobilenumber) {
		
		String message = userDao.getOTP(mobilenumber);
		return message;
		
	}

	@Override
	public String resendOTP(User user) {
		
		String message = userDao.resendOTP(user);
		// OT P send to Mobile Number..
		// write code here
		
		return message;
	}

	

	

	@Override
	public String verifyotp(User user) {
		
		
		return userDao.verifyotp(user);
	}

	
	@Override
	public String findByEmail(User user) {
		return userDao.findByEmail(user);
	}

	@Override
	public String resetpassword(User user) {
		return userDao.resetpassword(user);
	}

	
}
