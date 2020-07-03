package com.lmj.model;

public class Data {

	private String title;
	private String content;
	private String ansnum;
	private Integer u_id;
	private String username;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnsnum() {
		return ansnum;
	}

	public void setAnsnum(String ansnum) {
		this.ansnum = ansnum;
	}
}
