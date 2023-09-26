package com.card.game.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.card.game.beans.CardRequest;
import com.card.game.beans.CardResp;
import com.card.game.beans.Color;
import com.card.game.beans.Value;

/**
 * @author a.tigoudern
 *
 */
@Service
public class CardGameSetviceImpl implements CardGameService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CardGameSetviceImpl.class);
	
	static final int NUMBER_OF_CARDS= 10;

	/**
	 * Gets hand cards.
	 *
	 * @return the cards
	 */
	@Override
	public List<CardResp> getHandCards() {
		LOGGER.trace("Hand cards");
		
		final List<CardResp> hand = new ArrayList<>();
		final List<CardResp> allCards = this.buildCardsDeck();
		
   	 	// Remove the top card from the deck
	    for (int i = 0; i < NUMBER_OF_CARDS; i++) {
	        hand.add(allCards.get(0));
	        allCards.remove(0);
	    }
		return hand;
	}

	
	/**
	 * Builds the cards deck(all cards).
	 *
	 * @return the list
	 */
	private List<CardResp> buildCardsDeck(){
		LOGGER.trace("build cards deck");
		
		final List<CardResp> cardsDeck = new ArrayList<>();
		
        for (Color color : Color.values()) 
            for (Value value : Value.values()) {
            	
            	final CardResp card = CardResp.builder()
            			.id(UUID.randomUUID())
            			.color(color)
            			.colorValue(color.getValue())
            			.value(value)
            			.valueVal(value.getValue())
            			.build();
            	
            	cardsDeck.add(card);
	         }
        
        Collections.shuffle(cardsDeck);
        
        return cardsDeck;  
        
	}


	/**
	 * Sort hand cards who must be 10 cards.
	 *
	 * @param cardsRequest the cards request
	 * @return the list
	 */
	@Override
	public List<CardResp> sortCards(@Valid List<CardRequest> cardsRequest) {
		
		LOGGER.trace("Sort cards");
		
		if(cardsRequest == null)
			throw new IllegalArgumentException(" card to sort must not be null");
		
		if(cardsRequest.size() != 10)
			throw new IllegalArgumentException(" size of cards to sort must be 10");
		
	    // Sort the handOfCards using Java streams, first by suit and then by value
        final List<CardRequest> sortedHand = cardsRequest.stream()
                .sorted(Comparator.comparing(CardRequest::getValue).thenComparing(CardRequest::getColor))
                .collect(Collectors.toList());
        
        
        // mapp the result 
        final List<CardResp> sortedCardsResp = sortedHand.stream().map(card -> this.toResp(card))
        		.collect(Collectors.toList());
        
        return sortedCardsResp;
        		
	}
	
	
	/**
	 * To resp mapper.
	 *
	 * @param cardRequest the card request
	 * @return the card resp
	 */
	private CardResp toResp(CardRequest cardRequest) {
		
		final CardResp cardResp= CardResp.builder()
				.color(cardRequest.getColor())
				.colorValue(cardRequest.getColor().getValue())
				.id(cardRequest.getId())
				.value(cardRequest.getValue())
				.valueVal(cardRequest.getValue().getValue())
				.build();
		
		return cardResp;
	}
	
}
