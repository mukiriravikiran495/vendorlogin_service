package com.shifting_customers.service;

import java.util.List;
import java.util.Random;

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

	
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userDao.getUser();
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	public String createUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}
	@Override
	public User updatePartially(User user, int id) {
		userDao.updateCountry(user,id);
		return userDao.findById(id);
	}

	@Override
	public User update(User user,int id) {
		// TODO Auto-generated method stub
		return userDao.update(user, id);
	}

	@Override
	public String getOTP(User user) {
		int otp = generateOTP();
		user.setOtp(otp);
		String message = userDao.getOTP(user);
		return message;
		
	}

	@Override
	public String resendOTP(User user) {
		
		String message = userDao.resendOTP(user);
		// OT P send to Mobile Number..
		// write code here
		
		return message;
	}

	

	private int generateOTP() {
		int length = 4;
		char[] otp;
		String numbers = "0123456789"; 
		  
        // Using random method 
        Random rndm_method = new Random(); 
  
         otp = new char[length]; 
  
        for (int i = 0; i < length; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        int number =  Integer.parseInt(new String(otp));
        
		return number;
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
