package com.lmj.web;

import com.lmj.model.User;
import com.lmj.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FindPasswordAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	public String findPassword() throws Exception {
		
		if(user.getUsername()==""||user.getPassword()==""||user.getPhonenum()==""||user.getCheckPassword()=="") {
			System.out.println("�޸�ʧ��");
			ActionContext.getContext().put("error", "����д����Ϣ,��������!");
			return "fail";
		}
		if(!user.getPassword().equals(user.getCheckPassword())) {
			System.out.println("�޸�ʧ��");
			ActionContext.getContext().put("error", "������д�����벻һ��!");
			return "fail";
		}
		
		UserService userService = new UserService();
		boolean temp = userService.UpdateUserPassword(user);
		if(temp) {
			System.out.println("�޸ĳɹ�");
			return "success";
		}else {
			System.out.println("�޸�ʧ��");
			ActionContext.getContext().put("error", "��д��Ϣ����,�޸�ʧ��!");
			return "fail";
		}
	}
	
	@Override
	public User getModel() {
		return user;
	}
}
