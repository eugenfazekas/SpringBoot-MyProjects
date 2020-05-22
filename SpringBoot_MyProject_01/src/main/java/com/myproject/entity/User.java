package com.myproject.entity;

public class User {
	
		private Long id; 
				
		private String fullName;

		private String email;
			
		private String password;
		
		private String activation;
		
		private Boolean enabled;
		
		private String authority;
			
		public User() {
				}
		
		public User(String fullName, String email, String password, String activation, Boolean enabled, String authority) {
			this.fullName = fullName;
			this.email = email;
			this.password = password;
			this.activation = activation;
			this.enabled = enabled;
			this.authority = authority;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
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
			return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password
					+ ", activation=" + activation + ", enabled=" + enabled + ", authority=" + authority + "]";
		}

}
