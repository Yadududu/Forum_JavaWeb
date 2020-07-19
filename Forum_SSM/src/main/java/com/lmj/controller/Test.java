package com.lmj.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmj.service.UserService;

@Controller
@RequestMapping("/account")
public class Test {

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping("/findAll")
	public String findAll(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Test");
		String username = userService.FindUsernamebyId("1");
		model.addAttribute("username", username);
		System.out.println(username);
		System.out.println(request.getContextPath() + "/success");
//		response.sendRedirect(request.getContextPath()+"/success.jsp");
//		request.getRequestDispatcher("/success.jsp").forward(request, response);

		return "success";
	}

	@RequestMapping("/test")
	public String findAll() {
		System.out.println("Test2");
		return "success";
	}
}
