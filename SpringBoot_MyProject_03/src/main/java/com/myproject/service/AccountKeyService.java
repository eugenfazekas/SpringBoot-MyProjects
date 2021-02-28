package com.myproject.service;

import com.myproject.model.AccountKey;

public interface AccountKeyService {
	
	void createAccountKeyCollection();
	
	void dropAccountKeyCollection();

	void createAccountKey(AccountKey account);
	
	boolean keyCheck(String key);
	
	void removeKey(String key);
	
	AccountKey accountKey(String key);
}
