package com.lmj.service;

import com.lmj.dao.UserDao;
import com.lmj.model.User;

public class UserService {

	public User FindUserbyUsernameAndPassword(User user) {
		UserDao userDao = new UserDao();
		User u = userDao.FindUserbyUsernameAndPassword(user.getUsername(),user.getPassword());
		return u!=null?u:null;
	}
	public boolean IsExistUserbyUsername(String username) {
		UserDao userDao = new UserDao();
		User user = userDao.FindUserbyUsername(username);
		return user!=null?true:false;
	}

	public boolean InsertUser(User user) {
		UserDao userDao = new UserDao();
		User u = userDao.FindUserbyUsername(user.getUsername());
		if(u==null) {
			userDao.InsertUser(user);
			return true;
		}else {
			return false;
		}
	}

	public Boolean UpdateUserPassword(User user) {
		UserDao userDao = new UserDao();
		int temp = userDao.UpdateUserPassword(user);
		return temp==0?false:true;
	}
	
	public String FindUsernamebyId(String userID) {
		UserDao userDao = new UserDao();
		User user= userDao.FindUserbyId(userID);
		return user.getUsername();
	}
	
}
