package com.lmj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.model.User;
import com.lmj.service.AnswerService;
import com.lmj.service.DataService;

@Controller
public class DataController {
	
	@Autowired
	private DataService dataService;
	@Autowired
	private AnswerService answerService;

	@RequestMapping("/addData")
	public String addData(Data data,ModelMap model){
		
		data.setAnsnum(0);
		User user = (User) model.get("user");
		data.setU_id(user.getId());
		data.setUsername(user.getUsername());
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = format.format(date);
		data.setDtime(time);
		
		dataService.InsertData(data);
		String id = dataService.FindDataIdByData(data);
		if(id=="") {
			System.out.println("发布失败");
			return "add";
		}else {
			model.addAttribute("id", id);
			System.out.println("发布成功");
			return "success";
		}
	}
	
	@RequestMapping("/addAnswer")
	public String addAnswer(Answer answer,String dId,ModelMap model){
		User user = (User) model.get("user");
		answer.setU_id(user.getId());
		answer.setD_id(dId);
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = format.format(date);
		answer.setAtime(time);
		
		answerService.InsertAnswer(answer);
		
		//回答数+1
		dataService.UpdateDataAnsnum(answer.getD_id(),1);
		
		return "redirect:index.jsp?dId="+answer.getD_id();
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(String dId){
		
		ModelAndView model = new ModelAndView();
		
		//返回帖子内容
		Data data = new Data();
		data = dataService.FindDataById(dId);
		model.addObject("data", data);
		
		//返回回答内容
		List<Answer> answers=answerService.FindAllAnswer(dId);
//		UserService userService = new UserService();
//		answers.forEach(answer->answer.setUsername(userService.FindUsernamebyId(answer.getU_id())));
//		answers.forEach(answer->System.out.println(answer.getUsername()));
		model.addObject("answers",answers);
		model.setViewName("detail.jsp");
		
		return model;
	}
}
