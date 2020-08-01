package com.lmj.model;

import java.util.HashSet;
import java.util.Set;

public class User {

	private String id;
	private String username;
	private String password;
	private String phonenum;
	private Boolean admin;
	private String checkPassword;
	
	private Set<Data> dataSet = new HashSet<Data>();
	private Set<Answer> answerSet = new HashSet<Answer>();

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Set<Data> getDataSet() {
		return dataSet;
	}

	public void setDataSet(Set<Data> dataSet) {
		this.dataSet = dataSet;
	}

	public Set<Answer> getAnswerSet() {
		return answerSet;
	}

	public void setAnswerSet(Set<Answer> answerSet) {
		this.answerSet = answerSet;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phonenum=" + phonenum
				+ ", admin=" + admin + ", checkPassword=" + checkPassword + ", dataSet=" + dataSet + ", answerSet="
				+ answerSet + "]";
	}
	
}
