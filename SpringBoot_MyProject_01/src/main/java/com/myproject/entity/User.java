package com.myproject.entity;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
		
		private final Logger log = LoggerFactory.getLogger(this.getClass());
	
		private Long id;
		
		private String firstName;
			
		private String lastName;

		private String email;
			
		private String password;
		
		private String activation;
		
		private Boolean enabled;
			
		private Set<Role> roles = new HashSet<Role>();
		
		public User() {
				}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
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

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
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

		public void addRoles(String roleName) {
			if (this.roles == null || this.roles.isEmpty()) 
				this.roles = new HashSet<>();
			this.roles.add(new Role(roleName));
			log.debug(roleName);
		}
		
		@Override
		public String toString() {
			return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
		}
}
