package com.lmj.web;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.model.User;
import com.lmj.service.UserService;

//@WebServlet("/VerifyUsername")
public class VerifyServlet extends HttpServlet {
	//ajax
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		if(username!=null) {
			UserService userService = new UserService();
			boolean isEmpty = username=="";
			if(isEmpty) {
				response.getWriter().append("{\"isSuccess\":"+!isEmpty+"}");
				return;
			}
			boolean isExist = userService.IsExistUserbyUsername(username);
			response.getWriter().append("{\"isSuccess\":"+!isExist+"}");
		}
		
		String password = request.getParameter("password");
		String checkPassword = request.getParameter("checkPassword");
		if(password!=null & checkPassword==null) {
			boolean isEmpty = password=="";
			response.getWriter().append("{\"isSuccess\":"+!isEmpty+"}");
		}
		if(checkPassword!=null) {
			boolean isEqual = checkPassword.equals(password);
			response.getWriter().append("{\"isSuccess\":"+isEqual+"}");
		}
		
		String phonenum = request.getParameter("phonenum");
		if(phonenum!=null) {
			boolean isEmpty = phonenum=="";
			if(isEmpty) {
				response.getWriter().append("{\"isSuccess\":"+!isEmpty+"}");
			}
			String pattern = "^[1]([3-9])[0-9]{9}$";
			String content = phonenum;
			boolean isMatch = Pattern.matches(pattern, content);
			response.getWriter().append("{\"isSuccess\":"+ isMatch +"}");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
