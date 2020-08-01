package com.lmj.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.lmj.model.User;
import com.lmj.util.SessionManager;

//@WebListener
public class SessionListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		if(event.getName().equals("user")) {
			User user = new User();
			user = (User)event.getValue();
			if(SessionManager.SessionMap.containsKey(user.getUsername())) {
				HttpSession httpSession = SessionManager.SessionMap.get(user.getUsername());
				httpSession.removeAttribute("user");
				SessionManager.SessionMap.remove(user.getUsername());
			}
			SessionManager.SessionMap.put(user.getUsername(), event.getSession());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
