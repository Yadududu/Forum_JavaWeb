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
	//��������
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		UserService userService =new UserService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkPassword = request.getParameter("checkPassword");
		String phonenum = request.getParameter("phonenum");
		
		if(username == "" || phonenum == "") {
			System.out.println("�޸�����ʧ��");
			request.setAttribute("findPasswordError", "�������û������ֻ���!");
			request.getRequestDispatcher("/findPassword.jsp").forward(request, response);
			return;
		}
		if (password != "" & password.equals(checkPassword)) {
			user.setPassword(password);
			user.setUsername(username);
			user.setPhonenum(phonenum);
		} else {
			System.out.println("�޸�����ʧ��");
			request.setAttribute("findPasswordError", "ȷ���������������벻ƥ��!");
			request.getRequestDispatcher("/findPassword.jsp").forward(request, response);
			return;
		}
		
		Boolean temp = userService.UpdateUserPassword(user);
		if(temp) {
			System.out.println("�޸�����ɹ�");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}else {
			System.out.println("�޸�����ʧ��");
			request.setAttribute("findPasswordError", "�û������ֻ��Ų�ƥ��!");
			request.getRequestDispatcher("/findPassword.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
