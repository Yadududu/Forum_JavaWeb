package com.lmj.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.lmj.model.Data;
import com.lmj.service.DataService;

//@WebListener
public class ApplicationListener implements ServletContextListener {

    public ApplicationListener() {
    	System.out.println("ApplicationListener");
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("application�����ٵ�");
    }
    //�����ʼ��
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("��ʼ��ҳ��");
    	DataService dataService = new DataService();
		List<Data> datas = dataService.FindAllData();
		
//		UserService userService = new UserService();
//		for(Data d:datas) {
//			d.setUsername(userService.FindUsernamebyId(d.getU_id()));
//		}
		
		arg0.getServletContext().setAttribute("initDatas", datas);
		
//		for (Data data : datas) {
//			System.out.println(data.id+","+data.username+","+ data.title + "," + data.content + "," + data.ansnum + "," + data.u_id);
//		}
    }
    
}
