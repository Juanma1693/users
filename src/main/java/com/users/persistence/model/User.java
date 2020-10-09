package com.users.persistence.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.users.pojo.UserPojo;

@Entity
@Table(name = "users")
public class User {

	@Id
	private String id;
	

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private LocalDateTime created = LocalDateTime.now();

	@Column(nullable = false)
	private LocalDateTime modified = LocalDateTime.now();

	@Column(nullable = false)
	private LocalDateTime lastLogin = LocalDateTime.now();

	@Column(nullable = true)
	private String token;

	@Column(nullable = true)
	private Boolean isActive = true;
	
	@OneToMany(mappedBy = "usersId")
	private List<Phone> phones;

	public User () {
		this.id = UUID.randomUUID (). toString ();
	}

	public User(UserPojo user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Phone> getPhones() {
		return phones;
	}
	
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	public UserPojo toEntity() {
		UserPojo users = new UserPojo();
		users.setEmail(this.email);
		users.setName(this.name);
		users.setPassword(this.password);
		return users;
	}
}
