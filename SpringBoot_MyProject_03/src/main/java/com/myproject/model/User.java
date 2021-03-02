package com.myproject.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String id;
	private String firstName;
	private String lastName;
	private String fullName;
	private String email;
	private String password;
	private String date_registered;
	private boolean active;
	private List<String> authorities = new ArrayList<String>();
	private List<String> articlesId;
	private Address address;

	public User() {
	}
	
	public User(String firstName, String lastName, String fullName, String email, String password,
			String date_registered, boolean active, List<String> authorities) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.date_registered = date_registered;
		this.active = active;
		this.authorities = authorities;
	}
	
	public User(String firstName, String lastName, String fullName, String email, String password,
			String date_registered, boolean active, List<String> authorities, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.date_registered = date_registered;
		this.active = active;
		this.authorities = authorities;
		this.address = address;
	}

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
	
	public String getDate_registered() {
		return date_registered;
	}
	public void setDate_registered(String date_registered) {
		this.date_registered = date_registered;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<String> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	public List<String> getArticlesId() {
		return articlesId;
	}
	public void setArticlesId(List<String> articlesId) {
		this.articlesId = articlesId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName
				+ ", email=" + email + ", password=" + password + ", date_registered=" + date_registered + ", active="
				+ active + ", authorities=" + authorities + ", articlesId=" + articlesId + ", address=" + address + "]";
	}
}
