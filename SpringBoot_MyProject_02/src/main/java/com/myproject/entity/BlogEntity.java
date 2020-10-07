package com.myproject.entity;

import java.util.Date;

public class BlogEntity {

	private int Id ;
	
	private String title;
	
	private String blog;
	
	private Date posted;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date date) {
		this.posted = date;
	}

	@Override
	public String toString() {
		return "BlogEntity [Id=" + Id + ", title=" + title + ", blog=" + blog + ", posted=" + posted + "]";
	}

	
}
