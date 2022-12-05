package com.learn.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.startup.model.SpringUser;
import com.learn.startup.model.UserRequest;
import com.learn.startup.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	/**
	 * Save User.
	 * @param userRequest
	 * @return
	 */
	public SpringUser saveUser(UserRequest userRequest) 
	{
		SpringUser newUser = new SpringUser();
		newUser.setUsername(userRequest.getUsername());
		newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
	
		return userRepository.save(newUser);
}
}
