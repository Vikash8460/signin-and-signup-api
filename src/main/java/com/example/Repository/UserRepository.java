package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId,String password);
}
