package com.lmj.model;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class construtor {
	
	private String _username;
	private String _password;
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public construtor(String username,String password) {
		_username=username;
		_password=password;
	}

	@Override
	public String toString() {
		return "construtor [_username=" + _username + ", _password=" + _password + ", user=" + user + "]";
	}

}
