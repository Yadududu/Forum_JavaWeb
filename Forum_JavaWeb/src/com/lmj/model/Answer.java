package com.lmj.model;

public class Answer {
	
	private Integer id;
	private String acontent;
	private Integer d_id;
	private Integer u_id;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", acontent=" + acontent + ", d_id=" + d_id + ", u_id=" + u_id + ", username="
				+ username + "]";
	}
	
	
}
