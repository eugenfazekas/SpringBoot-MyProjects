package com.myproject.repository;

import com.myproject.model.AccountKey;

public interface AccountKeyRepository {
	
	void createAccountKeyCollection();
	
	void dropAccountKeyCollection();

	void createAccountKey(AccountKey account);
}
