package com.myproject.repository;

import com.myproject.model.AccountKey;

public interface AccountKeyRepository {
	
	void createAccountKeyCollection();
	
	void dropAccountKeyCollection();

	void createAccountKey(AccountKey account);
	
	boolean keyCheck(String key);
	
	AccountKey accountKey(String key);
	
	void removeKey(String key);
}
