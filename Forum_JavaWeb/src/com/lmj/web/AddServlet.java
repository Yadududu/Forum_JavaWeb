package com.lmj.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.model.Data;
import com.lmj.model.User;
import com.lmj.service.DataService;
import com.lmj.util.SystemAttribute;

//@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	//Ìí¼ÓÌû×Ó
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Data data = new Data();
		data.setId(SystemAttribute.getUUID());
		data.setTitle(request.getParameter("title"));
		data.setDtime(SystemAttribute.getTime());
		data.setDcontent(request.getParameter("content"));
		data.setAnsnum(0);
		User user = (User) request.getSession().getAttribute("user");
		data.setU_id(user.getId());
		
		DataService dataService = new DataService();
		dataService.InsertData(data);
		request.getRequestDispatcher("/DetailServlet?id="+data.getId()).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
