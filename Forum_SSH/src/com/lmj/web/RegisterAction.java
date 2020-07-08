package com.lmj.web;

import java.util.regex.Pattern;

import com.lmj.model.User;
import com.lmj.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	
	public String register() throws Exception {
		
		if(user.getUsername()==""||user.getPassword()==""||user.getPhonenum()==""||user.getCheckPassword()=="") {
			System.out.println("注册失败");
			ActionContext.getContext().put("error", "请填写好信息,不能留空!");
			return "fail";
		}
		if(!user.getPassword().equals(user.getCheckPassword())) {
			System.out.println("注册失败");
			ActionContext.getContext().put("error", "两次填写的密码不一致!");
			return "fail";
		}
		String pattern = "^[1]([3-9])[0-9]{9}$";
		String content = user.getPhonenum();
		boolean isMatch = Pattern.matches(pattern, content);
		if(!isMatch) {
			System.out.println("注册失败");
			ActionContext.getContext().put("error", "手机格式错误!");
			return "fail";
		}
		
		UserService userService = new UserService();
		boolean temp =userService.InsertUser(user);
		if(temp) {
			System.out.println("注册成功");
			return "success";
		}else {
			System.out.println("注册失败");
			ActionContext.getContext().put("error", "用户名已存在!");
			return "fail";
		}
	}

	@Override
	public User getModel() {
		return user;
	}

}
