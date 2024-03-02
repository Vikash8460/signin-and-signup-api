package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.User;
import com.example.Service.UserService;



@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	@PostMapping("/registerUser1")
	@CrossOrigin(origins = "*")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		if(tempEmailId!=null && !"".equals(tempEmailId)) {
			User userobj=userService.fetchUserByEmailId(tempEmailId);
			if(userobj!=null) {
				throw new Exception("User "+tempEmailId+" are already exist");
			}
		}
		User userobj=null;
		userobj=userService.saveUser(user);
		return userobj;	
	}
	
	@PostMapping("/login1")
	@CrossOrigin(origins = "*")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		String tempPass=user.getPassword();
		User userobj=null;
			if(tempEmailId!=null && tempPass!=null) {
				
			userobj=userService.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
				
				}
			if(userobj==null) {
				throw new Exception("Bad credentials");
					
			}
			return userobj;
	}
	
	 @GetMapping
	 @CrossOrigin(origins = "*")
	    public ResponseEntity<List<User>> getAllUser() { 
	        List<User> user = userService.getAllUser();
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }
	
	 @PutMapping("/{id}")
	 @CrossOrigin(origins = "*")
	    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
		 User user = userService.updatedUser(id, updatedUser);
	        if (user != null) {
	            return new ResponseEntity<>(user, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	 @CrossOrigin(origins = "*")
	    public ResponseEntity<Void> deleteUserById(@PathVariable int id) {
		 userService.deleteUserById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	 
  }
