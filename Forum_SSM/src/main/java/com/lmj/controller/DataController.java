package com.lmj.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmj.model.Answer;
import com.lmj.model.Data;
import com.lmj.model.User;
import com.lmj.service.AnswerService;
import com.lmj.service.DataService;

@Controller
@RequestMapping("/data")
public class DataController {
	
	@Autowired
	private DataService dataService;
	@Autowired
	private AnswerService answerService;

	@RequestMapping("/addData")
	public String addData(Data data,HttpSession session){
		
		data.setAnsnum(0);
		User user = (User) session.getAttribute("user");
		data.setU_id(user.getId());
//		data.setUsername(user.getUsername());
		data.setUser(user);
		
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		data.setDtime(time);
		
		dataService.InsertData(data);
		String dId = dataService.FindDataIdByData(data);
		if(dId=="") {
			System.out.println("发布失败");
			return "add";
		}else {
			System.out.println("发布成功");
			return "redirect:detail?dId="+dId;
		}
	}
	
	@RequestMapping("/addAnswer")
	public String addAnswer(Answer answer,String dId,HttpSession session){
		User user = (User) session.getAttribute("user");
		answer.setU_id(user.getId());
		answer.setD_id(dId);
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		answer.setAtime(time);
		
		answerService.InsertAnswer(answer);
		
		//回答数+1
		dataService.UpdateDataAnsnum(answer.getD_id(),1);
		
		return "redirect:detail?dId="+answer.getD_id();
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(String dId){
		System.out.println(dId);
		ModelAndView model = new ModelAndView();
		
		//返回帖子内容
		Data data = new Data();
		data = dataService.FindDataById(dId);
		model.addObject("data", data);
		
		//返回回答内容
		List<Answer> answers=answerService.FindAllAnswer(dId);
		model.addObject("answers",answers);
		model.setViewName("detail");
		
		return model;
	}
	
	@RequestMapping("/deleData")
	public String deleData(String delId,HttpServletRequest request,HttpServletResponse response) throws IOException {
		dataService.DeleteDataById(delId);
//		System.out.println("删除成功");
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return null;
	}
	
	@RequestMapping("/deleAnswer")
	public String deleAnswer(String delId,String dId) {
		answerService.DeleteAnswerById(delId);
		
		//回答数-1
		dataService.UpdateDataAnsnum(dId,-1);
		
		return "redirect:detail?dId="+dId;
	}
}
