package com.by.gsu.pms.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.by.gsu.pms.entity.Registration;
import com.by.gsu.pms.entity.User;
import com.by.gsu.pms.repo.RegistrationRepository;
import com.by.gsu.pms.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RegistrationRepository bookingRepository;
	
	public List<Registration> loginUser(String userName, String password) throws Exception{
		
		User loginUser = userRepository.findByUserNameAndUserPassword(userName, password);
		
		if(loginUser!= null) 
		{
			return bookingRepository.findByUser(loginUser);
		}else {
			throw new Exception("No user found !!!");
		}
		
	}

	public Optional<User> getUserFromRepo(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		return user;
	}

}
