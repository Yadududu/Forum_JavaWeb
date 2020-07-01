package com.lmj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.lmj.model.User;
import com.lmj.service.UserService;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	//登陆
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		User user = new User();
		UserService userService = new UserService();
		user.username = request.getParameter("username");
		user.password = request.getParameter("password");
		int userID = userService.FindUser(user);
		user.id = userID;
		
		if (userID!=0) {
			System.out.println("LoginSuccess");
			request.getSession().setAttribute("user",user);
//			request.getSession().setAttribute("userID",userID);
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		} else {
			System.out.println("Loginfail");
			request.setAttribute("loginError", "你输入的用户或者密码有误,请重新输入!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
