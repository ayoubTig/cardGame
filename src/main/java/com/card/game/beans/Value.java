/**
 * 
 */
package com.card.game.beans;

/**
 * @author Tigoudern
 *
 */
public enum Value {
	
	DEUX("2"),
	TROIS("3"),
	QUATRE("4"),
	CINQ("5"),
	SIX("6"),
	SEPT("7"),
	HUIT("8"),
	NEUF("9"),
	DIX("10"),
	VALET("Valet"),
	DAME("Dame"),
	ROI("Roi"),
	AS("As");
	
	private String value;
	
	Value(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
