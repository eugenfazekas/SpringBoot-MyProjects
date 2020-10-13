package com.myproject.entity;

public class BlogEntity {

	private int Id ;
	
	private String title;
	
	private String blog;
	
	private String posted;

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

	public String getPosted() {
		return posted;
	}

	public void setPosted(String date) {
		this.posted = date;
	}

	@Override
	public String toString() {
		return "BlogEntity [Id=" + Id + ", title=" + title + ", blog=" + blog + ", posted=" + posted + "]";
	}

	
}
