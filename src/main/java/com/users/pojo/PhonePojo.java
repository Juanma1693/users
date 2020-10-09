package com.users.pojo;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.users.persistence.model.Phone;
import com.users.util.MessageException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhonePojo {
	@JsonProperty(access = Access.WRITE_ONLY)
	private String id;

	@NotNull(message = MessageException.NOT_NULL)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String usersId;
	
	@NotNull(message = MessageException.NOT_NULL)
	private String number;
	
	@NotNull(message = MessageException.NOT_NULL)
	private String citycode;
	
	@NotNull(message = MessageException.NOT_NULL)
	private String contrycode;

	public PhonePojo(Phone phone) {
		this.id = phone.getId();
		this.number = phone.getNumber();
		this.citycode = phone.getCitycode();
		this.contrycode = phone.getCountrycode();
	}

	public PhonePojo() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public Phone toEntity(boolean update) {
		Phone phone = new Phone();
		if(update) {
			phone.setId(this.id);
		}
		phone.setUsersId(this.usersId);
		phone.setNumber(this.number);
		phone.setCitycode(this.citycode);
		phone.setCountrycode(this.contrycode);
		return phone;
	}
}
