package com.myproject.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationForm {

	@NotNull
	@Size(min=2,max=20,message="firstName length shoud betwenn 1 to 10")
	@Pattern(regexp="\\b([^'\"/\\\\]+[A-Za-z0-9_.-])\\b")
	private String firstName;
	
	@NotNull
	@Size(min=2,max=20,message="LastName length shoud betwenn 1 to 10")
	@Pattern(regexp="\\b([^'\"/\\\\]+[A-Za-z0-9_.-])\\b")
	private String lastName;
	
	@NotNull(message="Email field should not be empty")
	@Pattern(regexp="\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b",message="Invalid email address")
	@Size(min=5,max=40,message="Email length shoud betwenn 6 to 10")
	private String email;
	
	@Size(min = 2,max = 20, message = "The field must be at least 5 characters")
	private String password;

	public RegistrationForm() {

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

	@Override
	public String toString() {
		return "RegistrationForm [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}

}
