package com.users.persistence.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.users.pojo.PhonePojo;

@Entity
@Table(name = "phone")
public class Phone {

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(nullable = false)
	private String usersId;

	@Column(nullable = false)
	private String number;

	@Column(nullable = false)
	private String citycode;

	@Column(nullable = false)
	private String countrycode;

	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "usersId", referencedColumnName = "id", insertable = false, updatable = false)
	private User users;
	

	public Phone(PhonePojo phone) {
		this.usersId = phone.getUsersId();
		this.number = phone.getNumber();
		this.citycode = phone.getCitycode();
		this.countrycode = phone.getContrycode();
	}
	
	public Phone() {}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public User getUsers() {
		return users;
	}
	
	public void setUsers(User users) {
		this.users = users;
	}
	
	public PhonePojo toPojo() {
		
		PhonePojo phone = new PhonePojo();
		phone.setCitycode(this.citycode);
		phone.setContrycode(this.countrycode);
		phone.setNumber(this.number);
		
		return phone;
	}
}