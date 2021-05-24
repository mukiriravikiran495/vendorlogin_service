package com.shifting_customers.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.shifting_customers.model.User;
import com.shifting_customers.service.UserService;


@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	UserService userService;

	
	
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
    @PostMapping( value = "/verifyotp", headers="Accept=application/json")
    public ResponseEntity<String> verifyotp(@RequestBody  User user ) {
    	
    	String message = userService.verifyotp(user);
    	return new ResponseEntity<String>(message,HttpStatus.OK);
    }
    
    @PostMapping( value = "/sendotp", headers = "Accept=application/json")
    public ResponseEntity<String> sendOTP(@RequestBody User user) {
    	String message;
    	String number = String.valueOf(user.getMobilenumber());
    	if(isValid(number)) {
    		 message = userService.getOTP(user);
		}
		else {
			return new ResponseEntity<String>("Invalid Number..!!",HttpStatus.NOT_ACCEPTABLE);
		}
    	
    	return new ResponseEntity<String>(message,HttpStatus.OK);
    }
    
    private boolean isValid(String number) {		
		Pattern p = Pattern.compile("\\d{10}"); 
		Matcher m = p.matcher(number); 
	    return (m.find() && m.group().equals(number)); 
		
	}
    
    @PutMapping( value = "/resendotp", headers="Accept=application/json")
    public ResponseEntity<String> resendOTP(@RequestBody User user) {
    	String message = null;
    	String number = String.valueOf(user.getMobilenumber());
    	if(isValid(number)) {
    		message = userService.resendOTP(user);
    	}else {
    		return new ResponseEntity<String>("Invalid Number ..!!",HttpStatus.OK);
    	}
    	return new ResponseEntity<String>(message,HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<String>  createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating User "+user.getName());
	     String message = userService.createUser(user);
	     
	     return new ResponseEntity<String>(message,HttpStatus.OK);
	 }

	 @GetMapping(path="/getallusers", headers="Accept=application/json")
	 public List<User> getAllUser() {	 
	  List<User> tasks=userService.getUsers();
	  return tasks;
	
	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody User currentUser)
	{
		System.out.println("sd");
	User user = userService.findById(currentUser.getUser_id());
	if (user==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	userService.update(currentUser, currentUser.getUser_id());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<User> updateUserPartially(@PathVariable("id") int id, @RequestBody User currentUser){
		User user = userService.findById(id);
		if(user ==null){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		User usr =	userService.updatePartially(currentUser, id);
		return new ResponseEntity<User>(usr, HttpStatus.OK);
	}
	
	@PostMapping( value = "/forgotpassword", headers = "Accept= application/json")
	public ResponseEntity<String> findByEmail(@RequestBody User user) {
		String message =  userService.findByEmail(user);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping( value = "/resetpassword", headers="Accept=application/json")
	public ResponseEntity<String> resetpassword(@RequestBody User user) {
		String message =  userService.resetpassword(user);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
}
