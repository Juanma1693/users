package com.users.util;

public class RegularExpression {
	public static final String EMAIL = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static final String PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=(.*\\d){2})[a-zA-Z\\d]{4,}$";
}
