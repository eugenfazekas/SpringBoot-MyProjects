package com.myproject.service.impl;

import org.springframework.stereotype.Service;

import com.myproject.model.AccountKey;
import com.myproject.repository.AccountKeyRepository;
import com.myproject.service.AccountKeyService;

@Service
public class AccountKeyServiceImpl implements AccountKeyService {
	
	private AccountKeyRepository accountKeyRepository;

	public AccountKeyServiceImpl(AccountKeyRepository accountKeyRepository) {
		this.accountKeyRepository = accountKeyRepository;
	}

	@Override
	public void createAccountKeyCollection() {
		
		accountKeyRepository.createAccountKeyCollection();
	}

	@Override
	public void dropAccountKeyCollection() {
		
		accountKeyRepository.dropAccountKeyCollection();
	}

	@Override
	public void createAccountKey(AccountKey account) {

		accountKeyRepository.createAccountKey(account);
	}

	@Override
	public boolean keyCheck(String key) {
	
		return accountKeyRepository.keyCheck(key);
	}

	@Override
	public void removeKey(String key) {

		accountKeyRepository.removeKey(key);
	}

	@Override
	public AccountKey accountKey(String key) {
	
		return accountKeyRepository.accountKey(key);
	}

}
