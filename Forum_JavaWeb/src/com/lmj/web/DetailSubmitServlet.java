package com.lmj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.model.Answer;
import com.lmj.model.User;
import com.lmj.service.AnswerService;

//@WebServlet("/DetailSubmitServlet")
public class DetailSubmitServlet extends HttpServlet {
	//Ìí¼Ó»Ø´ð
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Answer answer = new Answer();
		answer.setContent(request.getParameter("content"));
		answer.setUsername(((User) request.getSession().getAttribute("user")).getUsername());
		answer.setD_id(Integer.parseInt(request.getParameter("id").toString()));
		
		System.out.println(answer.getContent()+","+answer.getUsername()+","+answer.getD_id() );
		
		AnswerService answerService = new AnswerService();
		answerService.AddAnswer(answer);
		request.getRequestDispatcher("/DetailServlet?id="+answer.getD_id()).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
