package com.users.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.users.pojo.UserPojo;
import com.users.util.DataHelper;
import com.users.util.TestHelper;

@SpringBootTest
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest extends TestHelper {

	private static String urlTemplate = "/users";

	@Autowired
	private DataHelper dataHelper;

	@Test
	public void registerTest() throws Exception {
		mockMvc.perform(
				post(urlTemplate).contentType(APPLICATION_JSON_VALUE).content(json(dataHelper.getRegisterDefault())))
				.andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.id").isString()).andExpect(jsonPath("$.created").isNotEmpty())
				.andExpect(jsonPath("$.modified").isNotEmpty()).andExpect(jsonPath("$.lastLogin").isNotEmpty())
				.andExpect(jsonPath("$.token").isNotEmpty()).andExpect(jsonPath("$.isActive").isBoolean());
	}

	@Test
	public void registerTestErrorEmailNull() throws Exception {
		UserPojo userPojo = dataHelper.getRegisterDefault();
		userPojo.setEmail(null);
		mockMvc.perform(post(urlTemplate).contentType(APPLICATION_JSON_VALUE).content(json(userPojo))).andDo(print())
				.andExpect(status().isBadRequest()).andExpect(content().contentType(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.mensaje").value("[email] Valor no puede ser nulo"));
	}

	@Test
	public void registerTestErrorEmailRegularExpression() throws Exception {
		UserPojo userPojo = dataHelper.getRegisterDefault();
		userPojo.setEmail("jhon.doe@");
		mockMvc.perform(post(urlTemplate).contentType(APPLICATION_JSON_VALUE).content(json(userPojo))).andDo(print())
				.andExpect(status().isBadRequest()).andExpect(content().contentType(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.mensaje").value("[email] Formato de correo erroneo"));
	}

	@Test
	public void registerTestErrorNameNull() throws Exception {
		UserPojo userPojo = dataHelper.getRegisterDefault();
		userPojo.setName(null);
		mockMvc.perform(post(urlTemplate).contentType(APPLICATION_JSON_VALUE).content(json(userPojo))).andDo(print())
				.andExpect(status().isBadRequest()).andExpect(content().contentType(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.mensaje").value("[name] Valor no puede ser nulo"));
	}

	@Test
	public void registerTestErrorPasswordNull() throws Exception {
		UserPojo userPojo = dataHelper.getRegisterDefault();
		userPojo.setPassword(null);
		mockMvc.perform(post(urlTemplate).contentType(APPLICATION_JSON_VALUE).content(json(userPojo))).andDo(print())
				.andExpect(status().isBadRequest()).andExpect(content().contentType(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.mensaje").value("[password] Valor no puede ser nulo"));
	}

	@Test
	public void registerTestErrorPasswordRegex() throws Exception {
		UserPojo userPojo = dataHelper.getRegisterDefault();
		userPojo.setPassword("aB1n");
		mockMvc.perform(post(urlTemplate).contentType(APPLICATION_JSON_VALUE).content(json(userPojo))).andDo(print())
				.andExpect(status().isBadRequest()).andExpect(content().contentType(APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.mensaje").value("[password] Formato de contrase\\u00F1a erroneo"));
	}
}
