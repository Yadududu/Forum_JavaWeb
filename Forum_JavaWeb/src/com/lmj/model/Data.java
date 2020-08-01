package com.lmj.model;

public class Data {
	
	private Integer id;
	private String title;
	private String dcontent;
	private Integer ansnum;
	private Integer u_id;
	private String username;
	
	public Integer getAnsnum() {
		return ansnum;
	}

	public void setAnsnum(Integer ansnum) {
		this.ansnum = ansnum;
	}
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
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getDcontent() {
		return dcontent;
	}

	public void setDcontent(String dcontent) {
		this.dcontent = dcontent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", title=" + title + ", dcontent=" + dcontent + ", ansnum=" + ansnum + ", u_id="
				+ u_id + ", username=" + username + "]";
	}
	
}
