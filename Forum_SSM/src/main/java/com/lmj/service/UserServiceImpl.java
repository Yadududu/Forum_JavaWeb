package com.lmj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmj.dao.UserMapper;
import com.lmj.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
//	@Qualifier("userMapper")
//	@Resource(type = UserMapper.class)
//	@Resource(name = "userMapper")
	private UserMapper userDao;

	@Override
	public User FindUserByUsernameAndPassword(User user) {
		User u = userDao.FindUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		return u!=null?u:null;
	}
	@Override
	public boolean FindUserByUsername(String username) {
		User u = new User();
		u.setUsername(username);
		User user = userDao.FindUserByUser(u);
		return user!=null?true:false;
	}
	@Override
	public String FindUsernameById(String id) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User u = new User();
		u.setId(id);
		User user = userDao.FindUserByUser(u);
		return user.getUsername();
	}
	@Override
	public boolean InsertUser(User user) {
		User u = userDao.FindUserByUsername(user.getUsername());
		if(u==null) {
			userDao.InsertUser(user);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean UpdateUserPassword(User user) {
		User u = userDao.FindUserByUsernameAndPhonenum(user.getUsername(), user.getPhonenum());
		if(u!=null) {
			userDao.UpdateUserPassword(user);
			return true;
		}else {
			return false;
		}
	}
	

}
