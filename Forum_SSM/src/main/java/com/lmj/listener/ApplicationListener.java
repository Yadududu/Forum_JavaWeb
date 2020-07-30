package com.lmj.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.lmj.model.Data;
import com.lmj.service.DataService;
import com.lmj.service.DataServiceImpl;


//@WebListener
public class ApplicationListener implements ServletContextListener {
	
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
//    	System.out.println("≥ı ºªØ“≥√Ê");
    	DataService dataService = new DataServiceImpl();
    	List<Data> datas = dataService.FindAllData();
    	
//    	UserService userService = new UserService();
//    	datas.forEach(data->data.setUsername(userService.FindUsernamebyId(data.getU_id())));
    	arg0.getServletContext().setAttribute("initDatas", datas);
    }
	
}
