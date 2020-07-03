package com.lmj.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.lmj.model.Data;
import com.lmj.service.DataService;
import com.lmj.service.UserService;

//@WebListener
public class ApplicationListener implements ServletContextListener {

    public ApplicationListener() {
    	System.out.println("ApplicationListener");
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("application被销毁掉");
    }
    //任务初始化
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("初始化页面");
    	DataService dataService = new DataService();
		List<Data> datas = dataService.GetDatas();
		
		UserService userService = new UserService();
		for(Data d:datas) {
			d.setUsername(userService.FindUsername(d.getU_id()));
		}
		
		arg0.getServletContext().setAttribute("initDatas", datas);
		
//		for (Data data : datas) {
//			System.out.println(data.id+","+data.username+","+ data.title + "," + data.content + "," + data.ansnum + "," + data.u_id);
//		}
    }
	
}
