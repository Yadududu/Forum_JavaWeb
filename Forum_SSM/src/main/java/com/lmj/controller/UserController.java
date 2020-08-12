package com.lmj.controller;

import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lmj.exception.CustomException;
import com.lmj.model.User;
import com.lmj.service.UserService;
import com.lmj.util.SessionManager;

@Controller
@SessionAttributes(value = { "user" })
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/register")
	public ModelAndView register(User user, String checkPassword) {

		ModelAndView model = new ModelAndView();

		if (user.getUsername() == "" || user.getPassword() == "" || user.getPhonenum() == "" || checkPassword == "") {
			System.out.println("ע��ʧ��");
			model.addObject("error", "����д����Ϣ,��������!");
			model.setViewName("register");
			return model;
		}
		if (!user.getPassword().equals(checkPassword)) {
			System.out.println("ע��ʧ��");
			model.addObject("error", "������д�����벻һ��!");
			model.setViewName("register");
			return model;
		}
		String pattern = "^[1]([3-9])[0-9]{9}$";
		String content = user.getPhonenum();
		boolean isMatch = Pattern.matches(pattern, content);
		if (!isMatch) {
			System.out.println("ע��ʧ��");
			model.addObject("error", "�ֻ���ʽ����!");
			model.setViewName("register");
			return model;
		}

		boolean temp = userService.InsertUser(user);
		if (temp) {
			System.out.println("ע��ɹ�");
			model.setViewName("login");
			return model;
		} else {
			System.out.println("ע��ʧ��");
			model.addObject("error", "�û����Ѵ���!");
			model.setViewName("register");
			return model;
		}
	}

	@RequestMapping("/findPassword")
	public ModelAndView findPassword(User user, String checkPassword) {

		ModelAndView model = new ModelAndView();

		if (user.getUsername() == "" || user.getPassword() == "" || user.getPhonenum() == "" || checkPassword == "") {
			System.out.println("�޸�ʧ��");
			model.addObject("error", "����д����Ϣ,��������!");
			model.setViewName("findPassword");
			return model;
		}
		if (!user.getPassword().equals(checkPassword)) {
			System.out.println("�޸�ʧ��");
			model.addObject("error", "������д�����벻һ��!");
			model.setViewName("findPassword");
			return model;
		}

		boolean temp = userService.UpdateUserPassword(user);
		if (temp) {
			System.out.println("�޸ĳɹ�");
			model.setViewName("login");
			return model;
		} else {
			System.out.println("�޸�ʧ��");
			model.addObject("error", "��д��Ϣ����,�޸�ʧ��!");
			model.setViewName("findPassword");
			return model;
		}
	}

	@RequestMapping("/login")
	public ModelAndView login(User user) {
		ModelAndView model = new ModelAndView();

		User u = userService.FindUserByUsernameAndPassword(user);
		if (u == null) {
			System.out.println("��½ʧ��");
			model.addObject("loginError", "�û��������������!");
			model.setViewName("forward:login.jsp");
			return model;
		} else {
			System.out.println("��½�ɹ�");
			model.addObject("user", u);
			model.setViewName("redirect:index.jsp");
			return model;
		}
	}

	@RequestMapping("/logout")
	public String logout(ModelMap model, SessionStatus sessionStatus) {
		User user = (User) model.get("user");
		if (SessionManager.SessionMap.containsKey(user.getUsername())) {
			SessionManager.SessionMap.remove(user.getUsername());
		}
		sessionStatus.setComplete();
		return "redirect:index.jsp";
	}

	@RequestMapping("/responseJson")
	public @ResponseBody String responseJson(String username, String password, String checkPassword, String phonenum) {
//		System.out.println(username + "," + password + "," + checkPassword + "," + phonenum);
		String message = "";
		if (username != null) {
			boolean isEmpty = username == "";
			if (isEmpty) {
				message = "{\"isSuccess\":" + !isEmpty + "}";
				return message;
			}
			boolean isExist = userService.FindUserByUsername(username);
			message = "{\"isSuccess\":" + !isExist + "}";
		}

		if (password != null & checkPassword == null) {
			boolean isEmpty = password == "";
			message = "{\"isSuccess\":" + !isEmpty + "}";
		}
		if (checkPassword != null) {
			boolean isEqual = checkPassword.equals(password);
			message = "{\"isSuccess\":" + isEqual + "}";
		}

		if (phonenum != null) {
			boolean isEmpty = phonenum == "";
			if (isEmpty) {
				message = "{\"isSuccess\":" + !isEmpty + "}";
			}
			String pattern = "^[1]([3-9])[0-9]{9}$";
			String content = phonenum;
			boolean isMatch = Pattern.matches(pattern, content);
			message = "{\"isSuccess\":" + isMatch + "}";
		}
		return message;
	}
	
	@RequestMapping("/fail")
	public void fail() throws CustomException {
		System.out.println("fail()");
		try {
			int a=10/0;
		}catch(Exception e) {
			e.printStackTrace();
			throw new CustomException("404");
		}
	}
}
