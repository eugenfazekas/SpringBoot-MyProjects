package com.myproject.model;

import java.util.Arrays;

public class User {
	
	private String id;
	private String firstName;
	private String lastName;
	private String fullName;
	private String email;
	private String password;
	private boolean active;
	private String[] articlesId;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName() {
		this.fullName = this.firstName+ " "+ this.lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;			
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String[] getArticlesId() {
		return articlesId;
	}
	public void setArticlesId(String[] articlesId) {
		this.articlesId = articlesId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName
				+ ", email=" + email + ", password=" + password + ", active=" + active + ", articles="
				+ Arrays.toString(articlesId) + "]";
	}
}
