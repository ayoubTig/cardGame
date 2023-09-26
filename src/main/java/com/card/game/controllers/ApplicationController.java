package com.card.game.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.game.beans.UserCredential;

/**
 * @author Ayoub.tigoudern
 *
 */
@RestController
@RequestMapping("api/")
public class ApplicationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

	@Value("${com.card.game.username}")
	private String username;

	@Value("${com.card.game.password}")
	private String password;

    @GetMapping("/ping")
    public String getMetadata() {
        return "ok";
    }
    
	@PostMapping("/login")
	public ResponseEntity<?> checkUserCredential(@RequestBody @Valid UserCredential userCredential) {

		if (userCredential == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("LOGIN ERROR : Credentials not correct");

		}
		if (username.equals(userCredential.getUsername()) && password.equals(userCredential.getPassword())) {
			LOGGER.info("LOGIN SUCCESS");
			return ResponseEntity.ok("LOGIN SUCCESS");
		}

		LOGGER.error("LOGIN ERROR : Credentials not correct");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("LOGIN ERROR : Credentials not correct");
	}

	@GetMapping("/credentials")
	public UserCredential getUserCredential() {
		UserCredential userCredential = UserCredential.builder().username(username).password(password).build();
		return userCredential;

	}
}
