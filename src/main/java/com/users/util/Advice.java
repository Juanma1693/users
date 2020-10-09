package com.users.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advice {

	  	@ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {
	        Map<String, String> response = new HashMap<String, String>();
	        response.put(MessageException.MESSAGE, getFieldError(e));
	        return ResponseEntity.badRequest().body(response);
	    }


	    @ExceptionHandler(MessageException.class)
	    public ResponseEntity<Object> messageException(MessageException e) {
	        Map<String, String> response = new HashMap<String, String>();
	        response.put(MessageException.MESSAGE, e.getMessage());
	        return ResponseEntity.badRequest().body(response);
	    }
	    
	    @ExceptionHandler(EmptyResultDataAccessException.class)
	    public ResponseEntity<Object> dataAccessException(EmptyResultDataAccessException e) {
	        Map<String, String> response = new HashMap<String, String>();
	        response.put(MessageException.MESSAGE, "Registro no encontrado");
	        return ResponseEntity.badRequest().body(response);
	    }
	    
	    private String getFieldError(MethodArgumentNotValidException e) {
		FieldError fieldError = e.getBindingResult().getFieldErrors().stream().findFirst().get();
	        return "[" + fieldError.getField() + "] " + fieldError.getDefaultMessage();
	    }
}
