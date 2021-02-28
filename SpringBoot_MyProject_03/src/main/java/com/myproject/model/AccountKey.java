package com.myproject.model;

public class AccountKey {

	private String accountType;
	private String key;
	private String email;
	
	public AccountKey() {
	}
	
	public AccountKey(String accountType, String key, String email) {
		this.accountType = accountType;
		this.key = key;
		this.email = email;
	}

	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
