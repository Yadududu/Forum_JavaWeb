package com.lmj.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory=null;
	static {
		Configuration config=new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}
	
	public static Session getSession() {
		Session session=sessionFactory.openSession();
		return session;
	}
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
