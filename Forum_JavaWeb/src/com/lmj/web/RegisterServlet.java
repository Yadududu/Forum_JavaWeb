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

//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	//注册
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		UserService userService = new UserService();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkPassword = request.getParameter("checkPassword");
		String phonenum = request.getParameter("phonenum");

//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(checkPassword);
//		System.out.println(phonenum);

		if(username == "" || password == "" || checkPassword == "" || phonenum == "") {
			System.out.println("注册失败");
			request.setAttribute("registerError", "请填写好所有信息!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		if (password != "" & password.equals(checkPassword)) {
			user.setPassword(password);
			user.setUsername(username);
			user.setPhonenum(phonenum);
		} else {
			System.out.println("注册失败");
			request.setAttribute("registerError", "确认密码与设置密码不匹配!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		String pattern = "^[1]([3-9])[0-9]{9}$";
		String content = phonenum;
		boolean isMatch = Pattern.matches(pattern, content);
		if(!isMatch) {
			System.out.println("注册失败");
			request.setAttribute("registerError", "手机号码有误，请重填!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}

		boolean temp = userService.RegisterUser(user);
		if (temp) {
			System.out.println("注册成功");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {
			System.out.println("注册失败");
			request.setAttribute("registerError", "用户名已经存在,请重新输入用户名!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
