package com.jsj.hn.model;

import java.util.Date;

public class Message {
	private Integer id;
	private String title;
	private String content;
	private Date createDateTime;
	private Integer userId;
	private Integer pid;
	
	//创建一个没有与数据库有联系的username
	private String username;
	
	public Message() {
		super();
	}
	
	public Message(Integer id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", content=" + content + ", createDateTime=" + createDateTime
				+ ", userId=" + userId + ", pid=" + pid + ", username=" + username + "]";
	}
	
}
