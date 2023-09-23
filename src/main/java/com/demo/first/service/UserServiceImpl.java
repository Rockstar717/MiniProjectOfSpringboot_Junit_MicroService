package com.demo.first.service;

import org.springframework.stereotype.Service;

import com.demo.exceptionhandling.UserNotFoundException;
import com.demo.first.Dao.UserRepository;
import com.demo.first.entity.UserInfo;

@Service
public class UserServiceImpl implements UserService {

	 UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public String createUser(UserInfo userInfo) {
		userRepository.save(userInfo);
		return "success";	
	}

	@Override
	public UserInfo getUser(int userId) {
		if(userRepository.findById(userId).isEmpty())
			throw new UserNotFoundException("user does not exist");
		return userRepository.findById(userId).get();
	}
}
