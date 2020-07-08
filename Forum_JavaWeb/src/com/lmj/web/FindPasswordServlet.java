package com.lmj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.model.User;
import com.lmj.service.UserService;

//@WebServlet("/FindPasswordServlet")
public class FindPasswordServlet extends HttpServlet {
	//查找密码
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		UserService userService =new UserService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkPassword = request.getParameter("checkPassword");
		String phonenum = request.getParameter("phonenum");
		
		if(username == "" || phonenum == "") {
			System.out.println("修改密码失败");
			request.setAttribute("findPasswordError", "请输入用户名和手机号!");
			request.getRequestDispatcher("/findPassword.jsp").forward(request, response);
			return;
		}
		if (password != "" & password.equals(checkPassword)) {
			user.setPassword(password);
			user.setUsername(username);
			user.setPhonenum(phonenum);
		} else {
			System.out.println("修改密码失败");
			request.setAttribute("findPasswordError", "确认密码与设置密码不匹配!");
			request.getRequestDispatcher("/findPassword.jsp").forward(request, response);
			return;
		}
		
		Boolean temp = userService.UpdateUserPassword(user);
		if(temp) {
			System.out.println("修改密码成功");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}else {
			System.out.println("修改密码失败");
			request.setAttribute("findPasswordError", "用户名与手机号不匹配!");
			request.getRequestDispatcher("/findPassword.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
