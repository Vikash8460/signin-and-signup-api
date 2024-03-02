package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Model.User;
import com.example.Repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private static UserRepository userRepository;
	

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
     public User fetchUserByEmailId(String emailId) {
		
		return userRepository.findByEmailId(emailId);
	}
     public User fetchUserByEmailIdAndPassword(String emailId,String password) {
 		
 		return userRepository.findByEmailIdAndPassword(emailId,password);
 	}

	public List<User> getAllUser() {
		  return userRepository.findAll();
	}
	
	 public User getUserById(int id) {
	        return userRepository.findById(id).orElse(null);
	    }
	
	public User updatedUser(@PathVariable int id, @RequestBody User updatedUser) {
		User existingUser = getUserById(id);
	        
	        if (existingUser == null) {
	            // If the User with the given id doesn't exist, return null or throw an exception
	            return null;
	        }
	        
	        // Update the fields of the existing admin with the fields from the updatedAdmin object
	        existingUser.setEmailId(updatedUser.getEmailId());
	        existingUser.setName(updatedUser.getName());
	        existingUser.setMoblieno(updatedUser.getMoblieno());
	        existingUser.setPadd(updatedUser.getPadd());
	        existingUser.setTadd(updatedUser.getTadd());
	        existingUser.setCity(updatedUser.getCity());
	        existingUser.setState(updatedUser.getState());
	        existingUser.setPcode(updatedUser.getPcode());
	        
	        // Save the updated admin
	        return userRepository.save(existingUser);
	}

	public void deleteUserById(int id) {
		 userRepository.deleteById(id);
		
	}
          

}
