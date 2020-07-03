package com.lmj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.service.AnswerService;
import com.lmj.service.DataService;
import com.lmj.service.UserService;


//@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	//读取数据库帖子和回答信息
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dataID = Integer.parseInt(request.getParameter("id").toString());
		AnswerService answerService = new AnswerService();
		List<Answer> answers = answerService.FindAllAnswer(dataID);
		
		DataService dataService = new DataService();
		UserService userService = new UserService();
		for(Answer answer:answers) {
			answer.setUsername(userService.FindUsername(answer.getU_id()));
		}
		Data data = dataService.GetData(dataID);
		
		request.setAttribute("title", data.getTitle());
		request.setAttribute("content", data.getContent());
		request.setAttribute("username", userService.FindUsername(data.getU_id()));
		request.setAttribute("answers", answers);
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
		
//		for(Answer answer:answers) {
//			System.out.println(answer.d_id+","+answer.username+","+answer.content);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
