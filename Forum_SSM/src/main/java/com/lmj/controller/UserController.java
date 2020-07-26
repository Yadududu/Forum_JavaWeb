package com.lmj.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lmj.model.User;
import com.lmj.service.UserService;
import com.lmj.util.SessionManager;

@Controller
@SessionAttributes(value = {"user"})
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/register")
	public ModelAndView register(User user,String checkPassword) {
		
		ModelAndView model = new ModelAndView();
		
		if(user.getUsername()==""||user.getPassword()==""||user.getPhonenum()==""||checkPassword=="") {
			System.out.println("注册失败");
			model.addObject("error", "请填写好信息,不能留空!");
			model.setViewName("register");
			return model;
		}
		if(!user.getPassword().equals(checkPassword)) {
			System.out.println("注册失败");
			model.addObject("error", "两次填写的密码不一致!");
			model.setViewName("register");
			return model;
		}
		String pattern = "^[1]([3-9])[0-9]{9}$";
		String content = user.getPhonenum();
		boolean isMatch = Pattern.matches(pattern, content);
		if(!isMatch) {
			System.out.println("注册失败");
			model.addObject("error", "手机格式错误!");
			model.setViewName("register");
			return model;
		}
		
		boolean temp =userService.InsertUser(user);
		if(temp) {
			System.out.println("注册成功");
			model.setViewName("login");
			return model;
		}else {
			System.out.println("注册失败");
			model.addObject("error", "用户名已存在!");
			model.setViewName("register");
			return model;
		}
	}
	
	@RequestMapping("/findPassword")
	public ModelAndView findPassword(User user,String checkPassword){
		
		ModelAndView model = new ModelAndView();
		
		if(user.getUsername()==""||user.getPassword()==""||user.getPhonenum()==""||checkPassword=="") {
			System.out.println("修改失败");
			model.addObject("error", "请填写好信息,不能留空!");
			model.setViewName("findPassword");
			return model;
		}
		if(!user.getPassword().equals(checkPassword)) {
			System.out.println("修改失败");
			model.addObject("error", "两次填写的密码不一致!");
			model.setViewName("findPassword");
			return model;
		}
		
		boolean temp = userService.UpdateUserPassword(user);
		if(temp) {
			System.out.println("修改成功");
			model.setViewName("login");
			return model;
		}else {
			System.out.println("修改失败");
			model.addObject("error", "填写信息有误,修改失败!");
			model.setViewName("findPassword");
			return model;
		}
	}
	
	@RequestMapping("/login")
	public ModelAndView login(User user) {
		
		ModelAndView model = new ModelAndView();
		
		User u = userService.FindUserByUsernameAndPassword(user.getUsername(),user.getPassword());
		if(u==null) {
			System.out.println("登陆失败");
			model.addObject("loginError", "用户名或者密码错误!");
			model.setViewName("login");
			return model;
		}else {
			System.out.println("登陆成功");
			model.addObject("user", u);
			model.setViewName("index");
			return model;
		}
	}
	
	@RequestMapping("/logout")
	public String logout(ModelMap model,SessionStatus sessionStatus) {
		
	 	User user = (User) model.get("user");
	 	if(SessionManager.SessionMap.containsKey(user.getUsername())){
	 		SessionManager.SessionMap.remove(user.getUsername());
	 	}
	 	sessionStatus.setComplete();
	 	return "redirect:index.jsp";
	}
}
