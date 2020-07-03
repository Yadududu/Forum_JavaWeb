package com.lmj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.model.Data;
import com.lmj.model.User;
import com.lmj.service.DataService;

//@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	//Ìí¼ÓÌû×Ó
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Data data = new Data();
		data.setTitle(request.getParameter("title"));
		data.setContent(request.getParameter("content"));
		data.setAnsnum(0);
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user.getId());
		data.setU_id(user.getId());
		
		DataService dataService = new DataService();
		int dataID = dataService.AddData(data);
		request.getRequestDispatcher("/DetailServlet?id="+dataID).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
