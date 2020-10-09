package com.users.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.persistence.dao.PhoneDao;
import com.users.persistence.dao.UserDao;
import com.users.pojo.UserPojo;
import com.users.pojo.UserResponsePojo;
import com.users.util.MessageException;
import com.users.util.Token;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PhoneDao phoneDao;

	final Log log = LogFactory.getLog(UserController.class);

	@GetMapping
	public ResponseEntity<Object> listUser() throws MessageException {
		return new ResponseEntity<Object>(userDao.listUsers(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Object> insertUser(@RequestBody @Valid UserPojo user) throws MessageException {
		userDao.validNotExistByEmail(user.getEmail());
		user.setToken(Token.createToken(user.getName()));
		UserResponsePojo userResponse = new UserResponsePojo(userDao.save(user.toEntity(false)));
		phoneDao.saveList(user.getPhones(), userResponse.getId());
		log.info("successful registration: " + userResponse.toString());

		return new ResponseEntity<Object>(userResponse, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> updateUser(@RequestBody @Valid UserPojo user) throws MessageException {
		UserResponsePojo userResponse = new UserResponsePojo(userDao.save(user.toEntity(true)));
		log.info("successful update: " + user.toString());
		return new ResponseEntity<Object>(userResponse, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Object> deleteUser(@RequestBody UserPojo user) throws MessageException {

		phoneDao.findByUsersId(user.getId()).forEach(phone -> phoneDao.delete(phone));
		userDao.deleteById(user.getId());
		log.info("successful delete: " + user.toString());
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
