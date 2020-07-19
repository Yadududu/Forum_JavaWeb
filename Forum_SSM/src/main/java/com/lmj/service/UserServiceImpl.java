package com.lmj.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.lmj.dao.UserMapper;
import com.lmj.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
//	@Qualifier("userMapper")
//	@Resource(type = UserMapper.class)
//	@Resource(name = "userMapper")
	private UserMapper userDao;

	@Override
	public User FindUserbyUsernameAndPassword(String username,String password) {
		User u = userDao.FindUserbyUsernameAndPassword(username,password);
		return u!=null?u:null;
	}
	@Override
	public boolean isExistUserbyUsername(String username) {
		User user = userDao.FindUserbyUsername(username);
		return user!=null?true:false;
	}
	@Override
	public String FindUsernamebyId(String id) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User user = userDao.FindUserbyId(id);
		return user.getUsername();
	}
	@Override
	public boolean InsertUser(User user) {
		User u = userDao.FindUserbyUsername(user.getUsername());
		if(u==null) {
			userDao.InsertUser(user);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean UpdateUserPassword(User user) {
		userDao.UpdateUserPassword(user);
		return true;
	}
	

}
