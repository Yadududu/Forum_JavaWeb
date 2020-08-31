package com.lmj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lmj.dao.UserDao;
import com.lmj.model.User;

@Service
public class UserService {
	
	@Resource
	private UserDao userDao;

	public User FindUserbyUsernameAndPassword(String username,String password) {
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userDao = ctx.getBean("userDao",UserDao.class);
		
//		System.out.println(sessionFactory);
//		Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
//		User u=null;
//		try {
//			u = userDao.FindUserbyUsernameAndPassword(username,password);
//		}catch(Exception e){
//			transaction.rollback();
//		}
//		transaction.commit();
		
		System.out.println(userDao);
		User u = userDao.FindUserbyUsernameAndPassword(username,password);
		
		return u!=null?u:null;
	}
	public boolean FindUserByUsername(String username) {
		User user = userDao.FindUserbyUsername(username);
		
		return user!=null?true:false;
	}

	public boolean InsertUser(User user) {
		User u = userDao.FindUserbyUsername(user.getUsername());
		if(u==null) userDao.InsertUser(user);
		
		return u==null?true:false;
	}
	
	public Boolean UpdateUserPassword(User user) {
		User u = userDao.FindUserbyUsernameAndPhonenum(user.getUsername(), user.getPhonenum());
		if(u!=null) {
			userDao.UpdateUserPassword(user);
		}
		
		return u==null?false:true;
	}
	
	public String FindUsernamebyId(String id) {
		User user= userDao.FindUserbyId(id);
		
		return user.getUsername();
	}

}
