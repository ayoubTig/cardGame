package com.card.game.beans;

import java.util.Objects;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ayoub tigoudern
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardResp {
	
	private UUID id;
	private Color color;
	private String colorValue;
	private Value value;
	private String valueVal; 
	
	@Override
	public int hashCode() {
		return Objects.hash(color, colorValue, id, value, valueVal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardResp other = (CardResp) obj;
		return color == other.color && Objects.equals(colorValue, other.colorValue) && Objects.equals(id, other.id)
				&& value == other.value && Objects.equals(valueVal, other.valueVal);
	}

	
}
