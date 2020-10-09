package com.users.pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.users.persistence.model.User;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponsePojo {
	
	private String id;
	
	private LocalDateTime created;

	private LocalDateTime modified;

	private LocalDateTime lastLogin;

	private String token;

	private Boolean isActive;
	
	public UserResponsePojo(User user) {
		this.id = user.getId();
		this.created = user.getCreated();
		this.modified = user.getModified();
		this.lastLogin = user.getLastLogin();
		this.token = user.getToken();
		this.isActive = user.getIsActive();
	}
	
	public UserResponsePojo() {}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
