package com.card.game.beans;

/**
 * @author ayoub tigoudern
 *
 */
public enum Color {
    CARREAUX("Carreaux"),
    COEUR("Coeur"),
    PIQUE("Pique"),
    TREFLE("Trèfle");
    
	private String value;
	
	Color(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
