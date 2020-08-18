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
    //�����½
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("����û��Ƿ��������ط���½");
    	
    	//�ж��Ƿ��е�¼
    	if(arg0.getName().equals("user")) {
    		User u = new User();
    		u = (User) arg0.getValue();
    		//�ж��Ƿ��������ͻ����Ѿ���¼
    		if(SessionManager.SessionMap.containsKey(u.getUsername())) {
    			//�������һ���ͻ��˵�session
    			HttpSession session = SessionManager.SessionMap.get(u.getUsername());
    			//�ѵ�¼��Ϣ������ͻ���Ĩ��
    			session.removeAttribute("user");
    			//��session���������Ƴ���Ӧ���û���
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
