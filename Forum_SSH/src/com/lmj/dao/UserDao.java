package com.lmj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lmj.model.User;

@Repository
public class UserDao {
	
	@Autowired
    private SessionFactory sessionFactory;

	public User FindUserbyUsernameAndPassword(String username,String password) {
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		
		Session session = sessionFactory.getCurrentSession();
		String sql = "Select * From user where username=? and password = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, username);
		query.setParameter(2, password);
		query.addEntity(User.class);
		
		User user = (User) query.uniqueResult();
		
		return user;
	}
	public User FindUserbyUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "Select * From user where username=?";
		NativeQuery query=session.createSQLQuery(sql);
		query.setParameter(1, username);
		query.addEntity(User.class);
		
		User user = (User) query.uniqueResult();
		
		return user;
	}
	public User FindUserbyId(String id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		
		return user;
	}
	public User FindUserbyUsernameAndPhonenum(String username,String phonenum) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "Select * From user where username=? and phonenum = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, username);
		query.setParameter(2, phonenum);
		query.addEntity(User.class);
		
		User user = (User) query.uniqueResult();
		
		return user;
	}
	public void InsertUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	public void UpdateUserPassword(User user) {
		Session session = sessionFactory.getCurrentSession();
		String sql="Select * from user where username = ? and phonenum = ?";
		NativeQuery query=session.createSQLQuery(sql);
		query.setParameter(1, user.getUsername());
		query.setParameter(2, user.getPhonenum());
		query.addEntity(User.class);
		
		User u = (User) query.uniqueResult();
		
		u.setPassword(user.getPassword());
		session.update(u);
	}
}
