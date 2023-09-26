package com.card.game.services;




import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.card.game.beans.CardRequest;
import com.card.game.beans.CardResp;
import com.card.game.beans.Color;
import com.card.game.beans.Value;

public class CardGameSetviceImplTest{
	
	private CardGameService cardService;
	
	
	@Before
    public void setUp() throws Exception  {
		cardService = new CardGameSetviceImpl();
    }

	@Test
	public void handCardsTest() {
		
		final List<CardResp> hand = cardService.getHandCards();
		final int size  = hand.size();
		assertEquals(CardGameSetviceImpl.NUMBER_OF_CARDS, size);
	}
	
	@Test
	public void sortCard() {
		
        final List<CardRequest> cardsHand = new ArrayList<>();
        
        cardsHand.add(CardRequest.builder()
                .id(UUID.fromString("8158b645-02fe-4384-b2c9-d606171e60d4"))
                .color(Color.TREFLE)
                .colorValue("Trèfle")
                .value(Value.DAME)
                .valueVal("Dame")
                .build());

        cardsHand.add(CardRequest.builder()
                .id(UUID.fromString("8425af51-dfde-464b-b3e5-2cb0958d7553"))
                .color(Color.CARREAUX)
                .colorValue("Carreaux")
                .value(Value.VALET)
                .valueVal("Valet")
                .build());
        
        cardsHand.add(CardRequest.builder()
                .id(UUID.fromString("3d5e2c43-754a-402f-8b31-ebbc3ce5b8ba"))
                .color(Color.PIQUE)
                .colorValue("Pique")
                .value(Value.HUIT)
                .valueVal("8")
                .build());

        cardsHand.add(CardRequest.builder()
                .id(UUID.fromString("3d62e02b-1195-48e7-a44f-4735eb38e25f"))
                .color(Color.TREFLE)
                .colorValue("Trèfle")
                .value(Value.SEPT)
                .valueVal("7")
                .build());

        cardsHand.add(CardRequest.builder()
                .id(UUID.fromString("05b09c31-8c46-4a43-a792-b5e680144bbc"))
                .color(Color.COEUR)
                .colorValue("Coeur")
                .value(Value.TROIS)
                .valueVal("3")
                .build());

        cardsHand.add(CardRequest.builder()
                .id(UUID.fromString("21d834b5-f989-4248-ad83-b63054f916f2"))
                .color(Color.COEUR)
                .colorValue("Coeur")
                .value(Value.VALET)
                .valueVal("Valet")
                .build());

        cardsHand.add(CardRequest.builder()
                .id(UUID.fromString("16a3da6f-d6d5-4ddb-bb09-9a18b2564f89"))
                .color(Color.CARREAUX)
                .colorValue("Carreaux")
                .value(Value.QUATRE)
                .valueVal("4")
                .build());

        cardsHand.add(CardRequest.builder()
                .id(UUID.fromString("50b15557-2d1d-4a9d-8885-f8093cde942b"))
                .color(Color.COEUR)
                .colorValue("Coeur")
                .value(Value.QUATRE)
                .valueVal("4")
                .build());

        cardsHand.add(CardRequest.builder()
                .id(UUID.fromString("c3215cf1-c4ec-43b9-8c0d-4515e2078856"))
                .color(Color.CARREAUX)
                .colorValue("Carreaux")
                .value(Value.AS)
                .valueVal("As")
                .build());

        cardsHand.add(CardRequest.builder()
                .id(UUID.fromString("857fa943-dd3b-47c5-8606-7dd76ef89175"))
                .color(Color.COEUR)
                .colorValue("Coeur")
                .value(Value.SEPT)
                .valueVal("7")
                .build());
        
        final List<CardResp>  sortedHand = new LinkedList<>();
        
        sortedHand.add(CardResp.builder()
	            .id(UUID.fromString("05b09c31-8c46-4a43-a792-b5e680144bbc"))
	            .color(Color.COEUR)
	            .colorValue("Coeur")
	            .value(Value.TROIS)
	            .valueVal("3")
	            .build());
        
        sortedHand.add(CardResp.builder()
                .id(UUID.fromString("16a3da6f-d6d5-4ddb-bb09-9a18b2564f89"))
                .color(Color.CARREAUX)
                .colorValue("Carreaux")
                .value(Value.QUATRE)
                .valueVal("4")
                .build());
        
        sortedHand.add(CardResp.builder()
                .id(UUID.fromString("50b15557-2d1d-4a9d-8885-f8093cde942b"))
                .color(Color.COEUR)
                .colorValue("Coeur")
                .value(Value.QUATRE)
                .valueVal("4")
                .build());
        
        sortedHand.add(CardResp.builder()
                .id(UUID.fromString("857fa943-dd3b-47c5-8606-7dd76ef89175"))
                .color(Color.COEUR)
                .colorValue("Coeur")
                .value(Value.SEPT)
                .valueVal("7")
                .build());
        sortedHand.add(CardResp.builder()
                .id(UUID.fromString("3d62e02b-1195-48e7-a44f-4735eb38e25f"))
                .color(Color.TREFLE)
                .colorValue("Trèfle")
                .value(Value.SEPT)
                .valueVal("7")
                .build());
        
        sortedHand.add(CardResp.builder()
                .id(UUID.fromString("3d5e2c43-754a-402f-8b31-ebbc3ce5b8ba"))
                .color(Color.PIQUE)
                .colorValue("Pique")
                .value(Value.HUIT)
                .valueVal("8")
                .build());
        
        sortedHand.add(CardResp.builder()
                .id(UUID.fromString("8425af51-dfde-464b-b3e5-2cb0958d7553"))
                .color(Color.CARREAUX)
                .colorValue("Carreaux")
                .value(Value.VALET)
                .valueVal("Valet")
                .build());
        sortedHand.add(CardResp.builder()
                .id(UUID.fromString("21d834b5-f989-4248-ad83-b63054f916f2"))
                .color(Color.COEUR)
                .colorValue("Coeur")
                .value(Value.VALET)
                .valueVal("Valet")
                .build());
        
        sortedHand.add(CardResp.builder()
                .id(UUID.fromString("8158b645-02fe-4384-b2c9-d606171e60d4"))
                .color(Color.TREFLE)
                .colorValue("Trèfle")
                .value(Value.DAME)
                .valueVal("Dame")
                .build());
        
        sortedHand.add(CardResp.builder()
                .id(UUID.fromString("c3215cf1-c4ec-43b9-8c0d-4515e2078856"))
                .color(Color.CARREAUX)
                .colorValue("Carreaux")
                .value(Value.AS)
                .valueVal("As")
                .build());


        final List<CardResp> sortedHandResults = cardService.sortCards(cardsHand);
        
        
        for(int i=0 ; i<10; i++) {
        	
        	final CardResp sortedHandCardRes =  sortedHandResults.get(i);
        	final CardResp sortedHandCard =  sortedHand.get(i);
        	
        	System.out.println("["+sortedHandCardRes.getColorValue() +", "+sortedHandCardRes.getValueVal()+"]<------>["+
        			sortedHandCard.getColorValue() +" , "+sortedHandCard.getValueVal()+"]");

        }
       
		
	}
	
	

}
