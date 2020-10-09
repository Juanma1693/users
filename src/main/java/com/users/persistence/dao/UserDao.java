package com.users.persistence.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import com.users.controller.UserController;
import com.users.persistence.model.User;
import com.users.pojo.UserPojo;
import com.users.util.MessageException;

public interface UserDao extends JpaRepository<User, String> {
	final Logger logger = LoggerFactory.getLogger(UserController.class);
	Optional<User> findByEmail(String email);
	
	default List<UserPojo> listUsers(){
		return StreamSupport.stream(findAll().spliterator(), false).map(UserPojo::new).collect(Collectors.toList());
	}
	
	default void validNotExistByEmail(String email) throws MessageException {
        Optional<User> users = findByEmail(email);
        if (users.isPresent()) {
            throw new MessageException(MessageException.EMAIL_EXISTS);
        }
    }
}
