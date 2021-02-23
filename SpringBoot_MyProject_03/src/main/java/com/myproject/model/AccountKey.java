package com.myproject.model;

public class AccountKey {

	private String accountType;
	private String key;
	
	public AccountKey() {
	}
	
	public AccountKey(String accountType, String key) {
		this.accountType = accountType;
		this.key = key;
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
}
