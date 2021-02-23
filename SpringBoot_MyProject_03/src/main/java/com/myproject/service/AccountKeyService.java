package com.myproject.service;

import com.myproject.model.AccountKey;

public interface AccountKeyService {
	
	void createAccountKeyCollection();
	
	void dropAccountKeyCollection();

	void createAccountKey(AccountKey account);

}
