package com.users.util;

public  class MessageException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "mensaje";
	public static final String NOT_NULL = "Valor no puede ser nulo";
    public static final String PASSWORD_ERROR = "Formato de contrase\\u00F1a erroneo";
    public static final String EMAIL_EXISTS = "El correo ya existe";
    public static final String EMAIL_FORMAT_ERROR = "Formato de correo erroneo";
    
    public MessageException(String message){
        super(message);
    }
}
