package com.myproject.entity;

public class ImageEntity {

	private String id;
	
	private String name;
	
	private String posted;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPosted() {
		return posted;
	}
	public void setPosted(String posted) {
		this.posted = posted;
	}
	
	@Override
	public String toString() {
		return "ImageEntity [id= " + id + ", name= " + name + ", posted= " + posted + "]";
	}
	
}
