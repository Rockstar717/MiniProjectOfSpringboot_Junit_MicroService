package com.demo.first.service;


import java.util.List;

import com.demo.first.entity.UserInfo;

public interface UserService {
	
	public  String createUser(UserInfo userInfo);
	
	public String updateUser(UserInfo userInfo);
	
	public String deleteUser(UserInfo userInfo);
	
	public List<UserInfo> getUser();
	
	public UserInfo findUserById(int userId);

	

}
