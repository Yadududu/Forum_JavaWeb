package com.lmj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.service.AnswerService;
import com.lmj.service.DataService;


@WebServlet("/DeleAnswerServlet")
public class DeleAnswerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int delId = Integer.parseInt(request.getParameter("delId"));
		int id = Integer.parseInt(request.getParameter("id"));
		AnswerService answerService = new AnswerService();
		answerService.DeleAnswerById(delId);
		System.out.println("É¾³ý³É¹¦");
		
		DataService dataService = new DataService();
		dataService.UpdateDataAnsnum(id, -1);
		
		request.getRequestDispatcher("/DetailServlet?id="+id).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
