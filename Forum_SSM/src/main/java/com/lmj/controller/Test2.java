package com.lmj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test2 {
	@RequestMapping("/test3")
	public String test() {
		System.out.println("Test3");
		return "success";
	}
	@RequestMapping("/test4")
	public void test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Test4");
		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return ;
	}
	
	@RequestMapping("/test5")
	public ModelAndView test5() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Test5");
		mv.setViewName("success");
		return mv;
	}
	@RequestMapping("/test6")
	public String test6() {
		System.out.println("Test6");
		return "forward:success.jsp";
	}
}
