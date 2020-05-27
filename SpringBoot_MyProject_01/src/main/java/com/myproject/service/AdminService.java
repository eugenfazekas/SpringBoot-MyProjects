package com.myproject.service;

import com.myproject.entity.RegistrationForm;

public interface AdminService {
		
	void registerAdmin(RegistrationForm adminToRegister);

	void AdminInit();
	
	Integer findByActivation(String activationcode);
	
	public Integer adminExist(String email, String fullname);
	
	void deleteAdminByActication(String code);
	
}
