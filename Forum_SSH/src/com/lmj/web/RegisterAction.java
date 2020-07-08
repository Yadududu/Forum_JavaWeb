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
			System.out.println("ע��ʧ��");
			ActionContext.getContext().put("error", "����д����Ϣ,��������!");
			return "fail";
		}
		if(!user.getPassword().equals(user.getCheckPassword())) {
			System.out.println("ע��ʧ��");
			ActionContext.getContext().put("error", "������д�����벻һ��!");
			return "fail";
		}
		String pattern = "^[1]([3-9])[0-9]{9}$";
		String content = user.getPhonenum();
		boolean isMatch = Pattern.matches(pattern, content);
		if(!isMatch) {
			System.out.println("ע��ʧ��");
			ActionContext.getContext().put("error", "�ֻ���ʽ����!");
			return "fail";
		}
		
		UserService userService = new UserService();
		boolean temp =userService.InsertUser(user);
		if(temp) {
			System.out.println("ע��ɹ�");
			return "success";
		}else {
			System.out.println("ע��ʧ��");
			ActionContext.getContext().put("error", "�û����Ѵ���!");
			return "fail";
		}
	}

	@Override
	public User getModel() {
		return user;
	}

}
