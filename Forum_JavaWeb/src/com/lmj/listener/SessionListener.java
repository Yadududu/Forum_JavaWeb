package com.lmj.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.lmj.model.User;
import com.lmj.util.SessionManager;


//@WebListener
public class SessionListener implements HttpSessionAttributeListener {

    public SessionListener() {
        // TODO Auto-generated constructor stub
    }
    //单点登陆
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("检测用户是否在其他地方登陆");
    	
    	//判断是否有登录
    	if(arg0.getName().equals("user")) {
    		User u = new User();
    		u = (User) arg0.getValue();
    		//判断是否有其他客户端已经登录
    		if(SessionManager.SessionMap.containsKey(u.getUsername())) {
    			//获得另外一个客户端的session
    			HttpSession session = SessionManager.SessionMap.get(u.getUsername());
    			//把登录信息从这个客户端抹除
    			session.removeAttribute("user");
    			//从session集合里面移除对应的用户名
    			SessionManager.SessionMap.remove(u.getUsername());
    		}
    		SessionManager.SessionMap.put(u.getUsername(), arg0.getSession());
    	}
    }

    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
