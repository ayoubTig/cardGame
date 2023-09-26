package com.card.game.conf;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CardGameAdviceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CardGameAdviceController.class);

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<List<String>> handleBadRequest(ConstraintViolationException e) {
		
		final List<String> messages = new ArrayList<>();
		for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) 
			messages.add(constraintViolation.getMessage());
		LOGGER.trace(messages.toString());
		
		return ResponseEntity.badRequest().body(messages);
	}
	
	@ExceptionHandler({ BindException.class })
	public ResponseEntity<List<String>> handleBadRequest(BindException e) {
		
		final List<String> messages = new ArrayList<>();
		for (FieldError fieldError : e.getFieldErrors()) 
			messages.add(fieldError.getDefaultMessage());
		LOGGER.trace(messages.toString());
		
		return ResponseEntity.badRequest().body(messages);
	}
	
	@ExceptionHandler({ CardGameServiceException.class })
	public ResponseEntity<?> handleKit4tryingManagerServiceException(CardGameServiceException e) {
		
		LOGGER.warn(e.getMessage());
		
		return ResponseEntity.internalServerError().body(e.getMessage());
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<?> handleException(Exception e) {
		LOGGER.warn(e.getMessage());
		return ResponseEntity.internalServerError().body("500 - Internal Server Error");
	}

}
