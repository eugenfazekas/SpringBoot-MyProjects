package com.myproject.entity;

public class User {
	
		private int id; 
	
		private String firstName;
			
		private String lastName;

		private String email;
			
		private String password;
		
		private String activation;
		
		private Boolean enabled;
		
		private String authority;
			
		public User() {
				}
		
		public User(String firstName, String lastName, String email, String password, String activation,
				Boolean enabled, String authority) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.activation = activation;
			this.enabled = enabled;
			this.authority = authority;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
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
		
		public String getActivation() {
			return activation;
		}

		public void setActivation(String activation) {
			this.activation = activation;
		}

		public Boolean getEnabled() {
			return enabled;
		}

		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}
				
		public String getAuthority() {
			return authority;
		}

		public void setAuthority(String authority) {
			this.authority = authority;
		}

		@Override
		public String toString() {
			return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
					+ password + ", activation=" + activation + ", enabled=" + enabled + ", authority=" + authority
					+ "]";
		}
}
