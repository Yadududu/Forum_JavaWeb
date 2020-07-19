package com.lmj.service;

import com.lmj.model.User;

public interface UserService {
	
	public User FindUserbyUsernameAndPassword(String username,String password);
	
	public boolean isExistUserbyUsername(String username);
	
	public String FindUsernamebyId(String id);
	
	public boolean InsertUser(User user);
	
	public boolean UpdateUserPassword(User user);
}
