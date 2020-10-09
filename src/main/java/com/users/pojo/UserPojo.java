package com.users.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.users.persistence.model.User;
import com.users.util.MessageException;
import com.users.util.RegularExpression;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojo {
	@JsonProperty(access = Access.WRITE_ONLY)
	private String id;
	
	@NotNull(message = MessageException.NOT_NULL)
	private String name;
	
	@Pattern(regexp = RegularExpression.EMAIL,message = MessageException.EMAIL_FORMAT_ERROR)
	@NotNull(message = MessageException.NOT_NULL)
	private String email;
	
	@Pattern(regexp = RegularExpression.PASSWORD,message = MessageException.PASSWORD_ERROR)
	@NotNull(message = MessageException.NOT_NULL)
	private String password;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String token;
	
	
	private Collection<PhonePojo> phones;
	
	public UserPojo(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.phones = new ArrayList<PhonePojo>();
		user.getPhones().forEach(phone -> phones.add(phone.toPojo()));
	}
	
	public UserPojo() {}

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

	public Collection<PhonePojo> getPhones() {
		return phones;
	}
	
	public void setPhones(Collection<PhonePojo> phones) {
		this.phones = phones;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User toEntity(boolean update) {
		User users = new User();
		if(update) {
			users.setId(this.id);
		}
		users.setEmail(this.email);
		users.setName(this.name);
		users.setPassword(this.password);
		users.setToken(this.token);
		return users;
	}

	
}
