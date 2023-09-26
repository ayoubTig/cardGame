package com.card.game.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author .a.tigoudern
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCredential {

	@Size(max = 30, message = "username max size is {max}")
	@NotNull(message="username is mandatory")
	private String username;
	
	@Size(max = 30, message = "password max size is {max}")
	@NotNull(message="password is mandatory")
	private String password;
	
}
