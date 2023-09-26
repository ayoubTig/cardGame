package com.card.game.beans;
import java.util.UUID;

import javax.validation.constraints.NotNull;

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
public class CardRequest {
	
	@NotNull(message="id is mondatory")
	private UUID id;
	
	
	@NotNull(message="color is mondatory")
	private Color color;
	private String colorValue;
	
	@NotNull(message="color is mondatory")
	private Value value;
	private String valueVal; 
	

}
