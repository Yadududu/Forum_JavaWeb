package com.lmj.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.model.User;
import com.lmj.service.UserService;
import com.lmj.service.AnswerService;
import com.lmj.service.DataService;

@Controller
@RequestMapping("/test")
public class Test {

	@Autowired
//	@Resource(name = "userServiceImpl")
	private UserService userService;

	@Autowired
	private DataService dataService;
	
	@Autowired
	private AnswerService answerService;

	@RequestMapping("/findUsernamebyId")
	public String findUsernamebyId(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("Test1");
		String username = userService.FindUsernameById("1");
		model.addAttribute("username", username);
		System.out.println(username);
		System.out.println(request.getContextPath() + "/success");
//		response.sendRedirect(request.getContextPath()+"/success.jsp");
//		request.getRequestDispatcher("/success.jsp").forward(request, response);

		return "success";
	}

	@RequestMapping("/insertUser")
	public String insertUser() {
		System.out.println("Test2");
		User user = new User();
//		user.setId("");
		user.setAdmin(false);
		user.setUsername("a22");
		user.setPassword("122");
		user.setPhonenum("1352");
		userService.InsertUser(user);

		return "success";
	}

	@RequestMapping("/findAllData")
	public String findAllData(Model model) {
		System.out.println("Test3");
		List<Data> list = dataService.FindAllData();
		list.forEach(data -> System.out.println(data));
		model.addAttribute("list",list);
		return "success";
	}
	
	@RequestMapping("/findDatabyId")
	public String findDatabyId() {
		System.out.println("Test4");
		Data data = dataService.FindDataById("2");
		System.out.println(data);
		return "success";
	}
	
	@RequestMapping("/insertData")
	public String insertData() {
		System.out.println("Test5");
		Data data = new Data();
//		data.setId("");
		data.setDtime("123");
		data.setTitle("title");
		data.setDcontent("dcontent");
		data.setAnsnum(1);
		data.setU_id("1");
		dataService.InsertData(data);
		return "success";
	}
	
	@RequestMapping("/updateDataAnsnum")
	public String updateDataAnsnum() {
		System.out.println("Test6");
		dataService.UpdateDataAnsnum("1", 2);
		return "success";
	}
	
	@RequestMapping("/deleteDataById")
	public String deleteDataById() {
		System.out.println("Test7");
		dataService.DeleteDataById("2");
		return "success";
	}
	
	@RequestMapping("/findAllAnswer")
	public String findAllAnswer() {
		System.out.println("Test8");
		List<Answer> list = answerService.FindAllAnswer("1");
		list.forEach(answer->System.out.println(answer));
		return "success";
	}
	
	@RequestMapping("/insertAnswer")
	public String insertAnswer() {
		System.out.println("Test9");
		Answer answer = new Answer();
		answer.setAtime("atime");
		answer.setAcontent("content");
		answer.setU_id("1");
		answer.setD_id("1");
		answerService.InsertAnswer(answer);
		return "success";
	}
	
	@RequestMapping("/deleteAnswerById")
	public String deleteAnswerById() {
		System.out.println("Test10");
		answerService.DeleteAnswerById("2");
		return "success";
	}
}
