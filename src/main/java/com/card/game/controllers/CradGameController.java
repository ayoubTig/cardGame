package com.card.game.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.game.beans.CardRequest;
import com.card.game.beans.CardResp;
import com.card.game.services.CardGameService;

/**
 * @author Ayoub.tigoudern
 *
 */
@RestController
@RequestMapping("api/game")
public class CradGameController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CradGameController.class);
	
	@Autowired
	private CardGameService cardGameService;
	
	@Value("${com.card.game.username}")
	private String usernameCardi;

	@Value("${com.card.game.password}")
	private String passwordCardi;
	
	/**
	 * Gets the cards.
	 *
	 * @return the cards
	 */
	@GetMapping("/hand-cards/{username}/{password}")
	public ResponseEntity<?> getHandCards(@PathVariable("username") @NotBlank(message = "username is mondatory") String username,
			@PathVariable("password") @NotBlank(message = "password is mondatory") String password) {
		
		if (!usernameCardi.equals(username) || !passwordCardi.equals(password)) {
			LOGGER.error("LOGIN ERROR : Credentials not correct");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("LOGIN ERROR : Credentials not correct");
		}
		LOGGER.debug("Getting hand crads started .......");
		
		final List<CardResp> cards = cardGameService.getHandCards();
		
		// logging the results
		cards.forEach(item -> LOGGER.trace("Card = {}",item));
		
		LOGGER.debug(">>>>Getting crads started");
		
		return ResponseEntity.ok(cards);

	}
	
	@PostMapping("/sort-hand-cards")
	public ResponseEntity<?> sortHandCard(@Valid @RequestBody List<CardRequest> cardsRequest) {
		
		LOGGER.debug(">>>>Sort hand cards started .......");
		
		if(cardsRequest == null)
			return ResponseEntity.badRequest().body("card to sort is null");
		
		if(cardsRequest.size() != 10)
			return ResponseEntity.badRequest().body("hand cards should be 10");
		
		final List<CardResp> sortedCards = cardGameService.sortCards(cardsRequest);
		
		LOGGER.debug("cards started .......");
		// logging the results
		sortedCards.forEach(item -> LOGGER.trace("Card = {}",item));
		
		LOGGER.debug(">>>>Getting crads started");
		
		return ResponseEntity.ok(sortedCards);

	}

}
