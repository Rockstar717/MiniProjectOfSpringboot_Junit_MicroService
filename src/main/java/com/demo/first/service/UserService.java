package com.demo.first.service;

import com.demo.first.entity.UserInfo;

public interface UserService {
	
	public  String createUser(UserInfo userInfo);
	
	public UserInfo getUser(int userId);

}
