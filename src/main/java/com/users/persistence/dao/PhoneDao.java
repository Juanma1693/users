package com.users.persistence.dao;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.persistence.model.Phone;
import com.users.pojo.PhonePojo;

public interface PhoneDao extends JpaRepository<Phone, String>{
	
	List<Phone> findByUsersId(String usersId);
	
	default void saveList(Collection<PhonePojo> phoneList, String id) {
		phoneList.forEach(phone -> phone.setUsersId(id));
		StreamSupport.stream(phoneList.spliterator(), false).map(Phone::new).collect(Collectors.toList()).forEach(phone -> save(phone));
	}
}
