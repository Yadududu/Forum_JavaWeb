package com.lmj.service;

import org.hibernate.Transaction;

import com.lmj.dao.UserDao;
import com.lmj.model.User;
import com.lmj.util.HibernateUtils;

public class UserService {

	public User FindUserbyUsernameAndPassword(String username,String password) {
		UserDao userDao = new UserDao();
		Transaction transaction=HibernateUtils.getCurrentSession().beginTransaction();
		User u=null;
		try {
			u = userDao.FindUserbyUsernameAndPassword(username,password);
		}catch(Exception e){
			transaction.rollback();
		}
		transaction.commit();
		
		return u!=null?u:null;
	}
	public boolean isExistUserbyUsername(String username) {
		UserDao userDao = new UserDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		User user = null;
		try{
			user = userDao.FindUserbyUsername(username);
		}catch(Exception e) {
			transaction.rollback();
		}
		transaction.commit();
		
		return user!=null?true:false;
	}

	public boolean InsertUser(User user) {
		UserDao userDao = new UserDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		User u=null;
		try {
			u = userDao.FindUserbyUsername(user.getUsername());
			if(u==null) userDao.InsertUser(user);
		}catch(Exception e) {
			transaction.rollback();
		}
		transaction.commit();
		
		return u==null?true:false;
	}
	
	public Boolean UpdateUserPassword(User user) {
		UserDao userDao = new UserDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		User u = null;
		try {
			u = userDao.FindUserbyUsernameAndPhonenum(user.getUsername(), user.getPhonenum());
			if(u!=null) {
				userDao.UpdateUserPassword(user);
			}
		}catch(Exception e) {
			transaction.rollback();
		}
		transaction.commit();
		return u==null?false:true;
	}
	
	public String FindUsernamebyId(String id) {
		UserDao userDao = new UserDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		User user=null;
		try {
			user= userDao.FindUserbyId(id);
		}catch(Exception e) {
			transaction.rollback();
		}
		transaction.commit();
		
		return user.getUsername();
	}

}
