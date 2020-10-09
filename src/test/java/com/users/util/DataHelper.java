package com.users.util;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.users.pojo.PhonePojo;
import com.users.pojo.UserPojo;

@Component
public class DataHelper {

    public UserPojo getRegisterDefaultEmpty() {
        return  new UserPojo();
    }

    public UserPojo getRegisterDefault() {
    	UserPojo userPojo = new UserPojo();
    	userPojo.setName("Jhon Doe");
    	userPojo.setEmail("jhon.doe@example.cl");
    	userPojo.setPassword("aB12");
		userPojo.setPhones(getPhonesDefault());
        return userPojo;
    }

    public Collection<PhonePojo> getPhonesDefault() {
        Collection<PhonePojo> phonePojos = new ArrayList<>();
        PhonePojo phonePojo = new PhonePojo();
        phonePojo.setNumber("1234567890");
        phonePojo.setCitycode("1");
        phonePojo.setContrycode("56");
        phonePojos.add(phonePojo);
        return phonePojos;
    }

}
