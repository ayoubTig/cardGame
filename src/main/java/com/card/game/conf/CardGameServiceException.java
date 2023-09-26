package com.card.game.conf;

/**
 *
 * @author ayoub tigoudern
 *
 */
public class CardGameServiceException extends RuntimeException {

	private static final long serialVersionUID = 5862983716612065843L;
	
	public CardGameServiceException(String message) {
		super(message);
	}

	public CardGameServiceException(String message, Throwable cause) {
        super(message, cause);
	}
}
