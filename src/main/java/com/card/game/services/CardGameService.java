/**
 * 
 */
package com.card.game.services;

import java.util.List;

import javax.validation.Valid;

import com.card.game.beans.CardRequest;
import com.card.game.beans.CardResp;

/**
 * @author Tigo
 *
 */
public interface CardGameService {

	public List<CardResp> getHandCards();

	public List<CardResp> sortCards(@Valid List<CardRequest> cardsRequest);
}
