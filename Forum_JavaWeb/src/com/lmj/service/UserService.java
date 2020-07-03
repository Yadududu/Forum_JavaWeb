package com.lmj.service;

import com.lmj.dao.UserDao;
import com.lmj.model.User;
import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

public class UserService {

	public int FindUserId(User user) {
		UserDao userDao = new UserDao();
		User u = userDao.FindUserId(user);
		if(u!=null) {
			return u.getId();
		}else {
			return 0;
		}
	}
	public boolean FindUser(String username) {
		UserDao userDao = new UserDao();
		User user = userDao.FindUser(username);
		if(user!=null) {
			return true;
		}else {
			return false;
		}
	}

	public boolean RegisterUser(User user) {
		UserDao userDao = new UserDao();
		User u = userDao.FindUserId(user);
		if(u==null) {
			userDao.InsertUser(user);
			return true;
		}else {
			return false;
		}
	}

	public Boolean UpdateUser(User user) {
		UserDao userDao = new UserDao();
		int temp = userDao.UpdateUser(user);
		return temp==0?false:true;
	}
	
	public String FindUsername(Integer id) {
		UserDao userDao = new UserDao();
		User user= userDao.FindUsername(id);
		return user.getUsername();
	}

}
