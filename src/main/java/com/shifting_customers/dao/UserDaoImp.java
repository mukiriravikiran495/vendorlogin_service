package com.shifting_customers.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shifting_customers.model.User;
import com.shifting_customers.model.User_booking;
import com.shifting_customers.model.User_profile;
@Repository("userDao")
@Transactional
public class UserDaoImp implements UserDao{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	  
	
	public String addUser(User val) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User user = findById(val.getUser_id());
		if( user.getEmail() == null ) {	
			user.setEmail(val.getEmail());
			user.setName(val.getName());
			user.setPassword(val.getPassword());
			session.save(user); 
			User_profile user_profile = new User_profile();
			
			user_profile.setUser_id(val.getUser_id());
			user_profile.setEmail(val.getEmail());
			user_profile.setMobilenumber(val.getMobilenumber());
			user_profile.setName(val.getName());
			session.save(user_profile);
			User_booking user_order = new User_booking();
			user_order.setUser_id(val.getUser_id());
			session.save(user_order);
			return " User Created";
		}			
		else {						
			return "User already Exists ..!!";
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
				
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		
		System.out.println(list);
		
			return list;
		
		
	}

	@SuppressWarnings("rawtypes")
	public User findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where  user_id=:userid");
		query.setParameter("userid", id);
		return (User) query.list().get(0);
	}

	public User update(User val, long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User user =(User)session.get(User.class, id);
		
		user.setName(val.getName());
		session.update(user);
		return user;
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User user = findById(id);
		session.delete(user);
	}
	@Override
	public User updateCountry(User val, long id){
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.load(User.class, id);
		
		return user;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String getOTP(User user) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where mobilenumber ="+user.getMobilenumber());
		List<User> list = query.list();
		
		if(list.isEmpty()) {
			session.save(user);
			return "OTP sent Succesfully to "+user.getMobilenumber();
			
		}
		else {
			User user2 = list.get(0);
			if(user.getMobilenumber() == user2.getMobilenumber() && user2.getEmail() == null) {
				return "OTP has already sent to "+user.getMobilenumber();
			}
			return "account already exists";	
		}
	}

	@SuppressWarnings({ "rawtypes", "null" })
	@Override
	public String resendOTP(User val) {
		int otp = 0;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where mobilenumber ="+val.getMobilenumber());
		User user = (User) query.list().get(0);
		
		if(user == null) {
			return user.getMobilenumber()+" Number Not Exists ";
		}
		
		
			otp = generateOTP();
			user.setOtp(otp);
			session.update(user);
			return "OTP sent again Succesfully to "+user.getMobilenumber();
		
	}
	
	@Override
	public String verifyotp(User val) {
		
		User user = findById(val.getUser_id());
		if(val.getOtp() == user.getOtp()) {
			return "Verified ..!! ";
		}else {
			return "Invalid OTP please enter again ..!!:";
		}
		
		
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String findByEmail(User user) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where email = :email");
		query.setParameter("email", user.getEmail());
		List<User> user2 =  query.list();
		if( user2.isEmpty()) {
			return "Mail Id not  Exists ..!!";
		}else
			return "Email Id  exists ..!!";
	}

	@Override
	public String resetpassword(User user) {
		Session session = sessionFactory.getCurrentSession();
		User user2 = findById(user.getUser_id());
		if( user2.getPassword().equals(user.getPassword())) {
			return "Please try with new Password ..!!";
		}else {
			user2.setPassword(user.getPassword());
			session.update(user2);
			return " password reset succesfully ..!!";
		}
		
	}
	

	
	
}
