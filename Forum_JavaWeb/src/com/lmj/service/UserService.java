package com.lmj.service;

import com.lmj.dao.UserDao;
import com.lmj.model.User;
import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

public class UserService {

	public int FindUser(User user) {
		UserDao userDao = new UserDao();
		User u = userDao.FindUser(user);
		if(u!=null) {
			return u.getId();
		}else {
			return 0;
		}
	}
	public boolean FindUser(String username) {
		UserDao userDao = new UserDao();
		if(userDao.FindUser(username)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean RegisterUser(User user) {
		UserDao userDao = new UserDao();
		return userDao.InsertUser(user);
	}

	public Boolean UpdateUser(User user) {
		UserDao userDao = new UserDao();
		return userDao.UpdateUser(user);
	}

}
