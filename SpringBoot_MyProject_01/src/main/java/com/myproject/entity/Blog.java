package com.myproject.entity;

import java.util.Date;


public class Blog {

	private Long id;
	
	private String blogger;
	
	private String title;
	
	private String content;
	
	private Date posted;

	public Long getId() {
		return id;
	}

	public Blog() {
	}

	public Blog(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBlogger() {
		return blogger;
	}

	public void setBlogger(String blogger) {
		this.blogger = blogger;
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

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", blogger=" + blogger + ", title=" + title + ", content=" + content + ", posted="
				+ posted + "]";
	}
	
}
